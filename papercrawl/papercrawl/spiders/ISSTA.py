# -*- coding: utf-8 -*-
import scrapy


class IsstaSpider(scrapy.Spider):
    name = 'ISSTA'
    allowed_domains = ['https://dblp.uni-trier.de/']
    start_urls = ['http://https://dblp.uni-trier.de//']

    def parse(self, response):
        pass
