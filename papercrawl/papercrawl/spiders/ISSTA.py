# -*- coding: utf-8 -*-
import re
import scrapy

from papercrawl.items import PaperItem, MeetingItem


class IsstaSpider(scrapy.Spider):
    name = 'ISSTA'
    # allowed_domains = ['https://dblp.uni-trier.de/']
    start_urls = ['https://dblp.uni-trier.de/db/conf/issta/index.html']

    def parse(self, response):
        view_hrefs = response.xpath('//*[@class="entry editor toc"]/nav/ul/li[1]/div[1]/a/@href').getall()
        for view_href in view_hrefs:
            return scrapy.Request(url=view_href, callback=self.view_parse)

    def view_parse(self, response):

        meeting_record_href = response.xpath('//*[@class="entry editor"]/nav/ul/li[2]/div[1]/a/@href').get()
        yield scrapy.Request(url=meeting_record_href, callback=self.meeting_parse)

        paper_record_href = response.xpath('//*[@class="entry inproceedings"]/nav/ul/li[2]/div[1]/a/@href').getall()
        paper_view_href = response.xpath('//*[@class="entry inproceedings"]/nav/ul/li[1]/div[1]/a/@href').getall()

        for index in range(0, len(paper_view_href)):
            yield scrapy.Request(url=paper_record_href[index], callback=self.paper_record_parse,
                                 cb_kwargs=dict(view_url=paper_view_href[index]))

    def meeting_parse(self, response):
        detail_meeting_info = response.xpath('//*[@id="bibtex-section"]/pre/text()').get()

        # 字符串处理
        text = detail_meeting_info.partition(',')
        text = '{' + text[2]
        text = re.sub(r'\s+', ' ', text)

        match = re.match(
            r'{ editor = {(.*?)}, title = {(.*?)}, publisher = {(.*?)}, year = {(.*?)}, url = {(.*?)}, doi = {(.*?)}, '
            r'isbn = {(.*?)}, timestamp = {(.*?)}, biburl = {(.*?)}, bibsource = {(.*?)} }', text)

        meeting = MeetingItem()
        meeting['editor'] = match.group(1)
        meeting['title'] = match.group(2)
        meeting['publisher'] = match.group(3)
        meeting['year'] = match.group(4)
        meeting['url'] = match.group(5)
        meeting['doi'] = match.group(6)
        meeting['isbn'] = match.group(7)
        meeting['timestamp'] = match.group(8)
        meeting['bib_url'] = match.group(9)
        meeting['bib_source'] = match.group(10)

        return meeting

    def paper_record_parse(self, response, view_url):
        detail_paper_info = response.xpath('//*[@id="bibtex-section"]/pre/text()').get()
        # 字符串处理
        text = detail_paper_info.partition(',')
        text = '{' + text[2]
        text = re.sub(r'\s+', ' ', text)

        match = re.match(
            r'{ author = {(.*?)}, editor = {(.*?)}, title = {(.*?)}, booktitle = {(.*?)}, pages = {(.*?)}, '
            r'publisher = {(.*?)}, year = {(.*?)}, url = {(.*?)}, doi = {(.*?)}, timestamp = {(.*?)}, '
            r'biburl = {(.*?)}, bibsource = {(.*?)} }', text)

        paper = PaperItem()
        paper['author'] = match.group(1)
        paper['editor'] = match.group(2)
        paper['title'] = match.group(3)
        paper['book_title'] = match.group(4)
        paper['pages'] = match.group(5)
        paper['publisher'] = match.group(6)
        paper['year'] = match.group(7)
        paper['url'] = match.group(8)
        paper['doi'] = match.group(9)
        paper['timestamp'] = match.group(10)
        paper['bib_url'] = match.group(11)
        paper['bib_source'] = match.group(12)

        return scrapy.Request(url=view_url, callback=self.paper_view_parse, cb_kwargs=dict(paper_item=paper))

    def paper_view_parse(self, response, paper_item):
        citation = response.xpath(
            '//*[@id="pb-page-content"]/div/main/div[2]/article/div[1]/div[2]/div/div[5]/div'
            '/div[1]/div/ul/li[1]/span/span[1]/text()').get()
        raw_abstract = response.xpath('//*[@class="abstractSection abstractInFull"]/p/text()').getall()
        abstract = '\n'.join(str(i) for i in raw_abstract)
        paper_item['citation'] = citation
        paper_item['abstract'] = abstract

        return paper_item
