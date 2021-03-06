import pymysql


def common_process(cursor, connect):
    get_paper_num = '''
    select count(*) from paper;
    '''
    get_author_num = '''
    select count(*) from author
    '''
    get_meeting_num = '''
    select count(*) from meeting
    '''
    get_affiliation_num = '''
    select count(*) from affiliation
    '''
    get_citation_num = '''
    select sum(citation) from paper
    '''
    update_statistic = '''
    update statistic set paper_num = %s , author_num = %s , meeting_num = %s , affiliation_num = %s ,
    citation_num = %s where statistic_id = 1;
    '''

    cursor.execute(get_paper_num)
    paper_num = cursor.fetchall()[0][0]

    cursor.execute(get_author_num)
    author_num = cursor.fetchall()[0][0]

    cursor.execute(get_meeting_num)
    meeting_num = cursor.fetchall()[0][0]

    cursor.execute(get_affiliation_num)
    affiliation_num = cursor.fetchall()[0][0]

    cursor.execute(get_citation_num)
    citation_num = cursor.fetchall()[0][0]

    cursor.execute(update_statistic, (paper_num, author_num, meeting_num, affiliation_num, citation_num))
    connect.commit()


def author_process(cursor, connect, authors):
    get_article_num = '''
    select count(*) from paper_author_relation where author_id = %s
    '''
    get_article_citation_num = '''
    select sum(p.citation) from paper p, paper_author_relation pr 
    where pr.author_id = %s and p.paper_id=pr.paper_id;
    '''
    update_author = '''
    update author set article_num = %s , article_citation_num = %s where author_id = %s;
    '''

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
    get_article_num = '''
    select count(distinct pr.paper_id) from 
    paper_author_relation pr, affiliation_author_relation ar
    where ar.affiliation_id = %s and pr.author_id=ar.author_id;
    '''
    get_article_citation_num = '''
    select sum(distinct p.citation)   
    from affiliation_author_relation ar, paper_author_relation pr, paper p 
    where ar.affiliation_id = %s and pr.author_id=ar.author_id and pr.paper_id=p.paper_id;
    '''
    get_author_num = '''
    select count(distinct author_id) from affiliation_author_relation 
    where affiliation_id = %s;
    '''
    update_affiliation = '''
    update affiliation 
    set article_num = %s , article_citation_num = %s  , author_num = %s
    where affiliation_id = %s;
    '''

    cursor.execute(select_all_affiliation)
    affiliations = cursor.fetchall()

    for affiliation in affiliations:
        cursor.execute(get_article_num, affiliation[0])
        article_num = cursor.fetchone()

        cursor.execute(get_article_citation_num, affiliation[0])
        article_citation_num = cursor.fetchone()

        cursor.execute(get_author_num, affiliation[0])
        author_num = cursor.fetchone()

        cursor.execute(update_affiliation, (article_num[0], article_citation_num[0], author_num[0], affiliation[0]))

        connect.commit()


def meeting_process(cursor, connect):
    select_all_meeting = '''
    select * from meeting;
    '''
    get_article_num = '''
    select count(distinct p.paper_id) from meeting m,paper p 
    where m.title=p.book_title and m.meeting_id=%s;
    '''
    get_article_citation_num = '''
    select sum(p.citation) from meeting m,paper p 
    where m.title=p.book_title and m.meeting_id=%s;
    '''
    get_author_num = '''
    select count(distinct ar.author_id) from meeting m,paper p,paper_author_relation ar 
    where m.title=p.book_title and p.paper_id=ar.paper_id and m.meeting_id=%s;
    '''
    get_affiliation_num = '''
    select count(distinct ar.affiliation_id) 
    from meeting m,paper p,paper_author_relation pr, affiliation_author_relation ar 
    where m.title=p.book_title and p.paper_id=pr.paper_id and ar.author_id=pr.author_id and m.meeting_id=%s;
    '''
    update_meeting = '''
    update meeting 
    set article_num = %s , article_citation_num = %s  , author_num = %s , affiliation_num = %s
    where meeting_id = %s;
    '''

    cursor.execute(select_all_meeting)
    meetings = cursor.fetchall()

    for meeting in meetings:
        cursor.execute(get_article_num, meeting[0])
        article_num = cursor.fetchone()

        cursor.execute(get_article_citation_num, meeting[0])
        article_citation_num = cursor.fetchone()

        cursor.execute(get_author_num, meeting[0])
        author_num = cursor.fetchone()

        cursor.execute(get_affiliation_num, meeting[0])
        affiliation_num = cursor.fetchone()

        cursor.execute(update_meeting,
                       (article_num[0], article_citation_num[0], author_num[0], affiliation_num[0], meeting[0]))

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
        meeting_process(cursor, connect)
        common_process(cursor, connect)

        cursor.close()
        connect.close()

    except Exception as e:
        print('------------------ fail to connect database ------------------', e)
