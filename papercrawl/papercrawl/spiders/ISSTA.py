# -*- coding: utf-8 -*-
import scrapy


class IsstaSpider(scrapy.Spider):
    name = 'ISSTA'
    allowed_domains = ['https://dblp.uni-trier.de/']
    start_urls = ['https://dblp.uni-trier.de/db/conf/issta/index.html']

    def parse(self, response):
        view_href = response.xpath('//*[@class="entry editor toc"]/nav/ul/li[1]/div[1]/a/@href').getall()
        record_href = response.xpath('//*[@class="entry editor toc"]/nav/ul/li[2]/div[1]/a/@href').getall()
        # self.logger.info('-------------------------------------------------------------------------------------------')
        # self.logger.info(record_href)
        # self.logger.info('-------------------------------------------------------------------------------------------')
