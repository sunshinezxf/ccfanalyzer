import pymysql


def author_process(cursor, connect, authors):
    get_article_num = '''select count(*) from paper_author_relation where author_id = %s'''
    get_article_citation_num = '''select sum(p.citation) from paper p, paper_author_relation pr 
    where pr.author_id = %s and p.paper_id=pr.paper_id;'''
    update_author = '''update author set article_num = %s , article_citation_num = %s where author_id = %s;'''

    for author in authors:
        cursor.execute(get_article_num, author[0])
        article_num = cursor.fetchone()
        # print('article num = ' + str(article_num[0]))

        cursor.execute(get_article_citation_num, author[0])
        citation_num = cursor.fetchone()
        # print('citations = ' + str(citation_num[0]))

        cursor.execute(update_author, (article_num[0], citation_num[0], author[0]))

        connect.commit()


def affiliation_process(cursor, connect):
    select_all_affiliation = '''select * from affiliation;'''

    cursor.execute(select_all_affiliation)
    affiliations = cursor.fetchall()

    for affiliation in affiliations:
        get_article_num = '''
        select count(distinct pr.paper_id) from 
        paper_author_relation pr, author_affiliation_relation ar
        where ar.affiliation_id = %s and pr.author_id=ar.author_id;
        '''
        get_article_citation_num = '''
        select sum(distinct p.citation)   
        from author_affiliation_relation ar, paper_author_relation pr, paper p 
        where ar.affiliation_id = %s and pr.author_id=ar.author_id and pr.paper_id=p.paper_id;
        '''
        get_author_num = '''
        select count(distinct author_id) from author_affiliation_relation 
        where affiliation_id = %s;
        '''
        update_affiliation = '''
        update affiliation 
        set article_num = %s , article_citation_num = %s  , author_num = %s
        where affiliation_id = %s;
        '''

        cursor.execute(get_article_num, affiliation[0])
        article_num = cursor.fetchone()

        cursor.execute(get_article_citation_num, affiliation[0])
        article_citation_num = cursor.fetchone()

        cursor.execute(get_author_num, affiliation[0])
        author_num = cursor.fetchone()
        # print(author_num[0])

        cursor.execute(update_affiliation, (article_num[0], article_citation_num[0], author_num[0], affiliation[0]))

        connect.commit()


if __name__ == '__main__':

    try:
        connect = pymysql.connect(host='localhost', port=3306, user='root', passwd='RV39LMgnYKvqpZuNW6R4',
                                  db='ccfdb')
        cursor = connect.cursor()
        print('------------------ succeed to connect database ------------------')

        select_all_author = '''select * from author'''
        cursor.execute(select_all_author)
        authors = cursor.fetchall()

        author_process(cursor, connect, authors)
        affiliation_process(cursor, connect)

        cursor.close()
        connect.close()

    except Exception as e:
        print('------------------ fail to connect database ------------------', e)
