# -*- coding: utf-8 -*-

# Define here the models for your scraped items
#
# See documentation in:
# https://docs.scrapy.org/en/latest/topics/items.html

from scrapy.item import Item, Field


class PaperItem(Item):
    author = Field()
    editor = Field()
    title = Field()
    book_title = Field()
    pages = Field()
    publisher = Field()
    year = Field()
    url = Field()
    doi = Field()
    timestamp = Field()
    bib_url = Field()
    bib_source = Field()
    citation = Field()
    abstract = Field()


class MeetingItem(Item):
    editor = Field()
    title = Field()
    publisher = Field()
    year = Field()
    url = Field()
    doi = Field()
    isbn = Field()
    timestamp = Field()
    bib_url = Field()
    bib_source = Field()
