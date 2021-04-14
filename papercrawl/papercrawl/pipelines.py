# -*- coding: utf-8 -*-

# Define your item pipelines here
#
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html
import pymysql

from papercrawl.items import PaperItem, MeetingItem, OmitMeetingItem


class PapercrawlPipeline(object):

    def __init__(self):
        try:
            self.connect = pymysql.connect(host='localhost', port=3306, user='root',
                                           passwd='''RV39LMgnYKvqpZuNW6R4''', db='ccfdb')
            self.cursor = self.connect.cursor()
            print('------------------ succeed to connect database ------------------')
        except Exception as e:
            print('------------------ fail to connect database ------------------', e)

    def process_item(self, item, spider):
        if isinstance(item, PaperItem):
            self.paper_insert(item)
        elif isinstance(item, MeetingItem):
            self.meeting_insert(item)
        # pass

    def paper_insert(self, paper):

        authors = paper['authors']
        author_affiliations = paper['author_affiliations']
        keywords = paper['keywords']

        insert_paper = '''
        insert into paper(title, abstract, citation, book_title, doi, pages, publisher, year, url,
         time, bib_url, bib_source) VALUES 
        (%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)
        '''
        query_author = '''
        select * from author where author = %s
        '''
        insert_author = '''
        insert into author(author) VALUES 
        (%s)
        '''
        query_keyword = '''
        select * from keyword where keyword = %s
        '''
        insert_keyword = '''
        insert into keyword(keyword) VALUES 
        (%s)
        '''
        insert_author_paper_relation = '''
        insert into paper_author_relation(paper_id,author_id) VALUES 
        (%s,%s)
        '''
        insert_keyword_relation = '''
        insert into paper_keyword_relation(paper_id, keyword_id) VALUES 
        (%s,%s)
        '''
        insert_ref = '''
        insert into paper_ref(paper_id, ref_count, ref_content) VALUES 
        (%s,%s,%s)
        '''
        insert_affiliation = '''
        insert into affiliation(affiliation) VALUES
        (%s)
        '''
        query_affiliation = '''
        select * from affiliation where affiliation= %s
        '''
        insert_affiliation_relation = '''
        insert into affiliation_author_relation(author_id, affiliation_id) VALUES 
        (%s,%s)
        '''
        query_author_relation = '''
        select * from author_relation 
        where (author_one_id = %s and author_two_id = %s) or (author_two_id = %s and author_one_id = %s)
        '''
        insert_author_relation = '''
        insert into author_relation(author_one_id, author_two_id, coop_time) VALUES
        (%s, %s, %s)
        '''
        update_author_relation = '''
        update author_relation set coop_time = %s where relation_id = %s'''

        paper_id = 0
        author_id = 0
        author_ids = []

        try:
            self.cursor.execute(insert_paper,
                                (paper['title'], paper['abstract'], paper['citation'], paper['book_title'],
                                 paper['doi'], paper['pages'], paper['publisher'], paper['year'],
                                 paper['url'], paper['timestamp'], paper['bib_url'], paper['bib_source']))

            paper_id = self.cursor.lastrowid

        except Exception as e:
            print('------------------------------------ paper insert failed ------------------------------------')
            print(e)

        for i in range(0, len(authors)):
            try:
                self.cursor.execute(query_author, authors[i])
                author_query = self.cursor.fetchone()

                if author_query is not None:
                    author_id = author_query[0]

                else:
                    self.cursor.execute(insert_author, authors[i])
                    author_id = self.cursor.lastrowid

                author_ids.append(author_id)
                self.cursor.execute(insert_author_paper_relation, (paper_id, author_id))

            except Exception as e:
                print('------------------------- author insert failed ------------------------')
                print(e)

            if len(author_affiliations) > i and author_affiliations[i] != '':
                affiliations = author_affiliations[i].split(' / ')
                for affiliation in affiliations:
                    try:
                        new_affiliation = affiliation.replace('，', ',')
                        self.cursor.execute(query_affiliation, new_affiliation)
                        affiliation_query = self.cursor.fetchone()

                        if affiliation_query is not None:
                            affiliation_id = affiliation_query[0]

                        else:
                            self.cursor.execute(insert_affiliation, new_affiliation)
                            affiliation_id = self.cursor.lastrowid

                        self.cursor.execute(insert_affiliation_relation, (author_id, affiliation_id))
                        self.connect.commit()

                    except Exception as e:
                        print('------------------------- affiliation insert failed ------------------------')
                        print(e)

        if keywords != '':
            try:
                for keyword in keywords:

                    self.cursor.execute(query_keyword, keyword)
                    keyword_query = self.cursor.fetchone()

                    if keyword_query is not None:
                        keyword_id = keyword_query[0]
                    else:
                        self.cursor.execute(insert_keyword, keyword)
                        keyword_id = self.cursor.lastrowid

                    self.cursor.execute(insert_keyword_relation, (paper_id, keyword_id))

                self.connect.commit()

            except Exception as e:
                print('------------------ keyword insert failed ------------------')
                print(e)

        try:
            for i in range(0, len(author_ids)):
                for j in range(i, len(author_ids)):
                    if i != j:
                        self.cursor.execute(query_author_relation,
                                            (author_ids[i], author_ids[j], author_ids[j], author_ids[i]))
                        author_relation_query = self.cursor.fetchone()

                        if author_relation_query is not None:
                            relation_id = author_relation_query[0]
                            self.cursor.execute(update_author_relation, (author_relation_query[3] + 1, relation_id))

                        else:
                            self.cursor.execute(insert_author_relation, (author_ids[i], author_ids[j], 1))

            self.cursor.execute(insert_ref, (paper_id, paper['ref_count'], paper['ref_content']))

            self.connect.commit()

        except Exception as e:
            print('------------------ author relation insert failed ------------------')
            print(e)

    def meeting_insert(self, meeting):

        editors = str(meeting['editor']).split(' and ')
        insert_meeting = '''
        insert into meeting(title, publisher, year, url, doi,isbn,time,bib_url,bib_source) VALUES 
        (%s,%s,%s,%s,%s,%s,%s,%s,%s)
        '''
        insert_editor = '''
        insert into editor(editor) VALUES 
        (%s)
        '''
        query_editor = '''
        select * from editor where editor = %s
        '''
        insert_editor_relation = '''
        insert into meeting_editor_relation(meeting_id,editor_id) VALUES 
        (%s,%s)
        '''
        try:
            self.cursor.execute(insert_meeting,
                                (meeting['title'], meeting['publisher'], meeting['year'], meeting['url'], meeting['doi']
                                 , meeting['isbn'], meeting['timestamp'], meeting['bib_url'], meeting['bib_source']))

            meeting_id = self.cursor.lastrowid
            for editor in editors:

                self.cursor.execute(query_editor, editor)
                editor_query = self.cursor.fetchone()

                if editor_query is not None:
                    editor_id = editor_query[0]
                else:
                    self.cursor.execute(insert_editor, editor)
                    editor_id = self.cursor.lastrowid

                self.cursor.execute(insert_editor_relation, (meeting_id, editor_id))

            self.connect.commit()

        except Exception as e:
            print('------------------ meeting insert failed ------------------')
            print(e)

    def omit_meeting_insert(self, meeting):

        editors = str(meeting['editor']).split(' and ')
        insert_meeting = '''
        insert into meeting(title, publisher, year, isbn, time, bib_url, bib_source) VALUES 
        (%s,%s,%s,%s,%s,%s,%s,%s,%s)
        '''
        insert_editor = '''
        insert into editor(editor) VALUES 
        (%s)
        '''
        insert_editor_relation = '''
        insert into meeting_editor_relation(meeting_id,editor_id) VALUES 
        (%s,%s)
        '''
        try:
            self.cursor.execute(insert_meeting,
                                (meeting['title'], meeting['publisher'], meeting['year'], meeting['isbn'],
                                 meeting['timestamp'], meeting['bib_url'], meeting['bib_source']))

            meeting_id = self.cursor.lastrowid
            for editor in editors:
                self.cursor.execute(insert_editor, editor)
                editor_id = self.cursor.lastrowid

                self.cursor.execute(insert_editor_relation, (meeting_id, editor_id))

            self.connect.commit()

        except Exception as e:
            print('------------------ meeting insert failed ------------------')
            print(e)
        pass

    def close_spider(self, spider):

        self.cursor.close()
        self.connect.close()

# with open('test.txt', 'a', encoding='utf-8') as fp:
#     fp.write(str(item))
# fp.close()
