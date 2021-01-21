# -*- coding: utf-8 -*-
import scrapy, re


class IsstaSpider(scrapy.Spider):
    name = 'ISSTA'
    # allowed_domains = ['https://dblp.uni-trier.de/']
    start_urls = ['https://dblp.uni-trier.de/db/conf/issta/index.html']

    def parse(self, response):
        view_hrefs = response.xpath('//*[@class="entry editor toc"]/nav/ul/li[1]/div[1]/a/@href').getall()
        for view_href in view_hrefs:
            return scrapy.Request(url=view_href, callback=self.view_parse)
        # self.logger.info('-------------------------------------------------------------------------------------------')
        # self.logger.info(record_href)
        # self.logger.info('-------------------------------------------------------------------------------------------')

    def view_parse(self, response):
        meeting_record_href = response.xpath('//*[@class="entry editor"]/nav/ul/li[2]/div[1]/a/@href').get()
        yield scrapy.Request(url=meeting_record_href, callback=self.meeting_parse)
        # self.logger.info('meeting_record_href = ' + meeting_record_href)
        # yield scrapy.Request(url='', callback=self.meeting_parse)
        # yield scrapy.Request(url='', callback=self.paper_parse)

    def meeting_parse(self, response):
        detail_meeting_info = response.xpath('//*[@id="bibtex-section"]/pre/text()').get()

        # 字符串处理
        text = detail_meeting_info.partition(',')
        text = '{' + text[2]
        text = re.sub(r'\s+', ' ', text)

        match = re.match(
            r'{ editor = {(.*?)}, title = {(.*?)}, publisher = {(.*?)}, year = {(.*?)}, url = {(.*?)}, doi = {(.*?)}, '
            r'isbn = {(.*?)}, timestamp = {(.*?)}, biburl = {(.*?)}, bibsource = {(.*?)} }',
            text)

        pass

    def paper_parse(self, response):
        pass
