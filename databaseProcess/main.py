from __future__ import division

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


def author_process(sql_cursor, sql_connect, authors):
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
        sql_cursor.execute(get_article_num, author[0])
        article_num = sql_cursor.fetchone()
        # print('article num = ' + str(article_num[0]))

        sql_cursor.execute(get_article_citation_num, author[0])
        citation_num = sql_cursor.fetchone()
        # print('citations = ' + str(citation_num[0]))

        sql_cursor.execute(update_author, (article_num[0], citation_num[0], author[0]))

        sql_connect.commit()


def affiliation_process(sql_cursor, sql_connect):
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

    sql_cursor.execute(select_all_affiliation)
    affiliations = sql_cursor.fetchall()

    for affiliation in affiliations:
        sql_cursor.execute(get_article_num, affiliation[0])
        article_num = sql_cursor.fetchone()

        sql_cursor.execute(get_article_citation_num, affiliation[0])
        article_citation_num = sql_cursor.fetchone()

        sql_cursor.execute(get_author_num, affiliation[0])
        author_num = sql_cursor.fetchone()

        sql_cursor.execute(update_affiliation, (article_num[0], article_citation_num[0], author_num[0], affiliation[0]))

        sql_connect.commit()


def meeting_process(sql_cursor, sql_connect):
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

    sql_cursor.execute(select_all_meeting)
    meetings = sql_cursor.fetchall()

    for meeting in meetings:
        sql_cursor.execute(get_article_num, meeting[0])
        article_num = sql_cursor.fetchone()

        sql_cursor.execute(get_article_citation_num, meeting[0])
        article_citation_num = sql_cursor.fetchone()

        sql_cursor.execute(get_author_num, meeting[0])
        author_num = sql_cursor.fetchone()

        sql_cursor.execute(get_affiliation_num, meeting[0])
        affiliation_num = sql_cursor.fetchone()

        sql_cursor.execute(update_meeting,
                           (article_num[0], article_citation_num[0], author_num[0], affiliation_num[0], meeting[0]))

        sql_connect.commit()


def author_radar_process(sql_cursor, sql_connect):
    get_author_num = '''
    select count(*) from author;
    '''
    get_article_num = '''
    select sum(article_num) from author;
    '''
    get_citation_num = '''
    select sum(article_citation_num) from author;
    '''
    get_max_paper_num = '''
    select max(article_num) from author;
    '''
    get_max_citation_num = '''
    select max(article_citation_num) from author;
    '''

    update_statistic = '''
    update statistic 
    set author_ave_article_num = %s , author_max_article_num = %s , author_ave_citation_num = %s , 
    author_max_citation_num = %s 
    where statistic_id = 1;
    '''

    radar_process(sql_cursor, sql_connect, get_author_num, get_article_num, get_citation_num, get_max_paper_num,
                  get_max_citation_num, update_statistic)


def affiliation_radar_process(sql_cursor, sql_connect):
    get_affiliation_num = '''
    select count(*) from affiliation;
    '''
    get_article_num = '''
    select sum(article_num) from affiliation;
    '''
    get_citation_num = '''
    select sum(article_citation_num) from affiliation;
    '''
    get_max_paper_num = '''
    select max(article_num) from affiliation;
    '''
    get_max_citation_num = '''
    select max(article_citation_num) from affiliation;
    '''
    get_author_num = '''
    select sum(author_num) from affiliation;
    '''
    get_max_author = '''
    select max(author_num) from affiliation;
    '''

    update_statistic = '''
    update statistic 
    set affiliation_ave_article_num = %s , affiliation_max_article_num = %s , affiliation_ave_citation_num = %s , 
    affiliation_max_citation_num = %s 
    where statistic_id = 1;
    '''
    update_author = '''
    update statistic
    set affiliation_ave_author_num = %s , affiliation_max_author_num = %s 
    where statistic_id=1;
    '''

    radar_process(sql_cursor, sql_connect, get_affiliation_num, get_article_num, get_citation_num, get_max_paper_num,
                  get_max_citation_num, update_statistic)

    sql_cursor.execute(get_author_num)
    author_num = sql_cursor.fetchone()[0]

    sql_cursor.execute(get_max_author)
    max_author_num = sql_cursor.fetchone()[0]

    sql_cursor.execute(get_affiliation_num)
    affiliation_num = sql_cursor.fetchone()[0]
    ave_affiliation_author_num = round(author_num / affiliation_num, 3)

    sql_cursor.execute(update_author, (ave_affiliation_author_num, max_author_num))

    sql_connect.commit()


def radar_process(sql_cursor, sql_connect, get_num: str, get_article_num: str, get_citation_num: str,
                  get_max_paper_num: str,
                  get_max_citation_num: str, update_statistic: str):
    sql_cursor.execute(get_num)
    author_num = sql_cursor.fetchone()[0]

    sql_cursor.execute(get_article_num)
    article_num = sql_cursor.fetchone()[0]

    sql_cursor.execute(get_citation_num)
    citation_num = sql_cursor.fetchone()[0]

    sql_cursor.execute(get_max_paper_num)
    max_paper_num = sql_cursor.fetchone()[0]

    sql_cursor.execute(get_max_citation_num)
    max_citation_num = sql_cursor.fetchone()[0]

    ave_article_num = round(article_num / author_num, 3)
    ave_citation_num = round(citation_num / author_num, 3)

    sql_cursor.execute(update_statistic,
                       (ave_article_num, max_paper_num, ave_citation_num, max_citation_num))

    sql_connect.commit()


if __name__ == '__main__':

    try:
        connect = pymysql.connect(host='rm-bp1tq50q3oeippagpio.mysql.rds.aliyuncs.com', port=3306, user='admin_1',
                                  passwd='''7j5Qp6v7dKESl9a41i8v''', db='ccfdb')
        cursor = connect.cursor()
        print('------------------ succeed to connect database ------------------')

        select_all_author = '''select * from author'''
        cursor.execute(select_all_author)
        authors = cursor.fetchall()

        author_process(cursor, connect, authors)
        affiliation_process(cursor, connect)
        meeting_process(cursor, connect)
        common_process(cursor, connect)
        author_radar_process(cursor, connect)
        affiliation_radar_process(cursor, connect)

        cursor.close()
        connect.close()

    except Exception as e:
        print('------------------ fail to connect database ------------------', e)
