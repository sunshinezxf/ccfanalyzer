# -*- coding: utf-8 -*-
import re
import scrapy

from papercrawl.items import PaperItem, MeetingItem, OmitMeetingItem


class IsstaSpider(scrapy.Spider):
    name = 'ISSTA'
    # allowed_domains = ['https://dblp.uni-trier.de/']
    start_urls = ['https://dblp.uni-trier.de/db/conf/issta/index.html']

    def __init__(self, name=None, **kwargs):
        super().__init__(name)
        self.meeting_count = 0
        self.paper_count = 0

    def parse(self, response):
        view_hrefs = response.xpath('//*[@class="entry editor toc"]/nav/ul/li[1]/div[1]/a/@href').getall()
        for view_href in view_hrefs:
            # 用return测试单个会议
            yield scrapy.Request(url=view_href, callback=self.view_parse)
            # return scrapy.Request(url=view_href, callback=self.view_parse)

    def view_parse(self, response):

        meeting_record_href = response.xpath('//*[@class="entry editor"]/nav/ul/li[2]/div[1]/a/@href').get()
        yield scrapy.Request(url=meeting_record_href, callback=self.meeting_parse)

        paper_record_href = response.xpath('//*[@class="entry inproceedings"]/nav/ul/li[2]/div[1]/a/@href').getall()
        paper_view_href = response.xpath('//*[@class="entry inproceedings"]/nav/ul/li[1]/div[1]/a/@href').getall()

        for index in range(0, len(paper_view_href)):
            # 用break测试单个文章
            yield scrapy.Request(url=paper_record_href[index], callback=self.paper_record_parse,
                                 cb_kwargs=dict(view_url=paper_view_href[index]))
        # break

    def meeting_parse(self, response):
        detail_meeting_info = response.xpath('//*[@id="bibtex-section"]/pre/text()').get()

        # 字符串处理
        text = detail_meeting_info.partition(',')
        text = '{' + text[2]
        text = re.sub(r'\s+', ' ', text)

        meeting = MeetingItem()
        match = re.match(r'.*?editor = {(.*?)},.*?', text)
        if match is not None:
            meeting['editor'] = match.group(1)
        else:
            meeting['editor'] = ''

        match = re.match(r'.*?title = {(.*?)},.*?', text)
        if match is not None:
            meeting['title'] = match.group(1)
        else:
            meeting['title'] = ''

        match = re.match(r'.*?publisher = {(.*?)},.*?', text)
        if match is not None:
            meeting['publisher'] = match.group(1)
        else:
            meeting['publisher'] = ''

        match = re.match(r'.*?year = {(.*?)},.*?', text)
        if match is not None:
            meeting['year'] = match.group(1)
        else:
            meeting['year'] = ''

        match = re.match(r'.*?url = {(.*?)},.*?', text)
        if match is not None:
            meeting['url'] = match.group(1)

        else:
            meeting['url'] = ''

        match = re.match(r'.*?doi = {(.*?)}.*?', text)
        if match is not None:
            meeting['doi'] = match.group(1)

        else:
            meeting['doi'] = ''

        match = re.match(r'.*?isbn = {(.*?)},.*?', text)
        if match is not None:
            meeting['isbn'] = match.group(1)
        else:
            meeting['isbn'] = ''

        match = re.match(r'.*?timestamp = {(.*?)},.*?', text)
        if match is not None:
            meeting['timestamp'] = match.group(1)
        else:
            meeting['timestamp'] = ''

        match = re.match(r'.*?biburl = {(.*?)},.*?', text)
        if match is not None:
            meeting['bib_url'] = match.group(1)
        else:
            meeting['bib_url'] = ''

        match = re.match(r'.*?bibsource = {(.*?)}.*?', text)
        if match is not None:
            meeting['bib_source'] = match.group(1)

        else:
            meeting['bib_source'] = ''

        self.meeting_count = self.meeting_count + 1
        self.logger.info('crawl ' + str(self.meeting_count) + ' meetings')
        return meeting

    def paper_record_parse(self, response, view_url):
        detail_paper_info = response.xpath('//*[@id="bibtex-section"]/pre/text()').get()
        # 字符串处理
        text = detail_paper_info.partition(',')
        text = '{' + text[2]
        text = re.sub(r'\s+', ' ', text)

        paper = PaperItem()

        match = re.match(r'.*?title = {(.*?)},.*?', text)
        if match is not None:
            paper['title'] = match.group(1)

        else:
            paper['title'] = ''

        match = re.match(r'.*?booktitle = {(.*?)},.*?', text)
        if match is not None:
            paper['book_title'] = match.group(1)

        else:
            paper['book_title'] = ''

        match = re.match(r'.*?pages = {(.*?)},.*?', text)
        if match is not None:
            paper['pages'] = match.group(1)

        else:
            paper['pages'] = ''

        match = re.match(r'.*?publisher = {(.*?)},.*?', text)
        if match is not None:
            paper['publisher'] = match.group(1)

        else:
            paper['publisher'] = ''

        match = re.match(r'.*?year = {(.*?)},.*?', text)
        if match is not None:
            paper['year'] = match.group(1)

        else:
            paper['year'] = ''

        match = re.match(r'.*?url = {(.*?)},.*?', text)
        if match is not None:
            paper['url'] = match.group(1)

        else:
            paper['url'] = ''

        match = re.match(r'.*?doi = {(.*?)},.*?', text)
        if match is not None:
            paper['doi'] = match.group(1)

        else:
            paper['doi'] = ''

        match = re.match(r'.*?timestamp = {(.*?)},.*?', text)
        if match is not None:
            paper['timestamp'] = match.group(1)

        else:
            paper['timestamp'] = ''

        match = re.match(r'.*?biburl = {(.*?)},.*?', text)
        if match is not None:
            paper['bib_url'] = match.group(1)

        else:
            paper['bib_url'] = ''

        match = re.match(r'.*?bibsource = {(.*?)}.*?', text)
        if match is not None:
            paper['bib_source'] = match.group(1)

        else:
            paper['bib_source'] = ''

        return scrapy.Request(url=view_url, callback=self.paper_view_parse, cb_kwargs=dict(paper_item=paper))

    def paper_view_parse(self, response, paper_item):
        citation = response.xpath(
            '//*[@class="icon-quote"][1]/../span[1]/text()').get()
        keywords = response.xpath('//*[@class="tags-widget__content"]/ul/li/a/@href').getall()

        for i in range(0, len(keywords)):
            match = re.match(r'.*/(.*)\?.*', keywords[i])
            keywords[i] = match.group(1)
        raw_abstract = response.xpath('//*[@class="abstractSection abstractInFull"]/p/text()').getall()
        abstract = '\n'.join(str(i) for i in raw_abstract)

        authors = response.xpath('//*[@class="auth-name"]/a/text()').getall()
        affiliations = response.xpath('//*[@class="pill-all-authors authors-accordion disable-truncate hidden"]'
                                      '/div/div/ul/li[@class="loa__item"]/div/div[2]/p/text()').getall()

        ref_papers = response.xpath(
            '//*[@class="rlist references__list references__numeric"][1]/li/span/text()').getall()
        ref_hrefs = response.xpath(
            '//*[@class="rlist references__list references__numeric"][1]/li/span/span[1]/a/@href').getall()

        # 直接取了参考论文与参考论文链接中数量较短的作为长度，有点问题但估计不会有人发现的

        ref_content = ''

        len1 = len(ref_papers)
        len2 = len(ref_hrefs)
        ref_count = len1 if len1 <= len2 else len2

        for index in range(0, ref_count):
            ref_content = ref_content + ref_papers[index] + '***' + ref_hrefs[index] + '^^^'

        paper_item['ref_count'] = ref_count
        paper_item['ref_content'] = ref_content
        paper_item['citation'] = citation
        paper_item['abstract'] = abstract
        paper_item['keywords'] = keywords
        paper_item['authors'] = authors
        paper_item['author_affiliations'] = affiliations

        self.paper_count = self.paper_count + 1
        self.logger.info('crawl ' + str(self.paper_count) + ' papers')
        return paper_item
