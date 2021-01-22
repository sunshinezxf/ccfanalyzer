# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html
import pymysql

from papercrawl.items import PaperItem, MeetingItem


class PapercrawlPipeline(object):

    def __init__(self):
        try:
            self.connect = pymysql.connect(host='localhost', port=3306, user='root', passwd='RV39LMgnYKvqpZuNW6R4',
                                           db='ccfdb')
            self.cursor = self.connect.cursor()
            print('------------------ succeed to connect database ------------------')
        except Exception as e:
            print('------------------ fail to connect database ------------------', e)

    def process_item(self, item, spider):
        if isinstance(item, PaperItem):
            self.paper_insert(item)
        elif isinstance(item, MeetingItem):
            self.meeting_insert(item)

    def paper_insert(self, paper):

        authors = str(paper['author']).split(' and ')
        keywords = paper['keywords']
        print('keywords = ', str(keywords))

        insert_paper = """
        insert into paper(title, abstract, citation, book_title, doi, pages, publisher, year, url,
         time, bib_url, bib_source) VALUES 
        (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)
        """
        insert_author = """
        insert into author(author) VALUES 
        (%s)
        """
        insert_keyword = """
        insert into keyword(keyword) VALUES 
        (%s)
        """
        insert_author_relation = """
        insert into paper_author_relation(paper_id,author_id) VALUES 
        (%s,%s)
        """
        insert_keyword_relation = """
        insert into paper_keyword_relation(paper_id, keyword_id) VALUES 
        (%s,%s)
        """

        try:
            self.cursor.execute(insert_paper,
                                (paper['title'], paper['abstract'], paper['citation'], paper['book_title'],
                                 paper['doi'], paper['pages'], paper['publisher'], paper['year'],
                                 paper['url'], paper['timestamp'], paper['bib_url'], paper['bib_source']))

            paper_id = self.cursor.lastrowid

            for author in authors:
                self.cursor.execute(insert_author, author)
                author_id = self.cursor.lastrowid
                self.cursor.execute(insert_author_relation, (paper_id, author_id))

            for keyword in keywords:
                self.cursor.execute(insert_keyword, keyword)
                keyword_id = self.cursor.lastrowid
                self.cursor.execute(insert_keyword_relation, (paper_id, keyword_id))

            self.connect.commit()

        except Exception as e:
            print('------------------ paper insert failed ------------------')
            print(e)

    def meeting_insert(self, meeting):
        editors = str(meeting['editor']).split(' and ')
        insert_meeting = """
        insert into meeting(title, publisher, year, url, doi,isbn,time,bib_url,bib_source) VALUES 
        (%s,%s,%s,%s,%s,%s,%s,%s,%s)
        """
        insert_editor = """
        insert into editor(editor) VALUES 
        (%s)
        """
        insert_editor_relation = """
        insert into meeting_editor_relation(meeting_id,editor_id) VALUES 
        (%s,%s)
        """
        try:
            self.cursor.execute(insert_meeting,
                                (meeting['title'], meeting['publisher'], meeting['year'], meeting['url'], meeting['doi']
                                 , meeting['isbn'], meeting['timestamp'], meeting['bib_url'], meeting['bib_source']))

            meeting_id = self.cursor.lastrowid
            for editor in editors:
                self.cursor.execute(insert_editor, editor)
                editor_id = self.cursor.lastrowid

                self.cursor.execute(insert_editor_relation, (meeting_id, editor_id))

            self.connect.commit()

        except Exception as e:
            print('------------------ meeting insert failed ------------------')
            print(e)

    def close_spider(self, spider):
        self.cursor.close()
        self.connect.close()
# with open('test.txt', 'a', encoding='utf-8') as fp:
#     fp.write(str(item))
# fp.close()
