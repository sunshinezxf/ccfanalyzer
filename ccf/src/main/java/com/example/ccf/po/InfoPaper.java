package com.example.ccf.po;

import java.util.List;

public class InfoPaper {

    private Integer paper_id;

    private String title;

    private String Abstract;

    private String doi;

    private Integer citation;

    private String book_title;

    private String pages;

    private String publisher;

    private String year;

    private String url;

    private String time;

    private String bib_url;

    private String bib_source;

    private List<String> authors;

    private List<String> keywords;


    public Integer getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(Integer paper_id) {
        this.paper_id = paper_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String Abstract) {
        this.Abstract = Abstract;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public Integer getCitation() {
        return citation;
    }

    public void setCitation(Integer citation) {
        this.citation = citation;
    }

    public String getBook_title() {
        return book_title;
    }

    public void setBook_title(String book_title) {
        this.book_title = book_title;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBib_url() {
        return bib_url;
    }

    public void setBib_url(String bib_url) {
        this.bib_url = bib_url;
    }

    public String getBib_source() {
        return bib_source;
    }

    public void setBib_source(String bib_source) {
        this.bib_source = bib_source;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public String toString() {
        return "InfoPaper{" +
                "paper_id=" + paper_id +
                ", title='" + title + '\'' +
                ", Abstract='" + Abstract + '\'' +
                ", doi='" + doi + '\'' +
                ", citation=" + citation +
                ", book_title='" + book_title + '\'' +
                ", pages='" + pages + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                ", url='" + url + '\'' +
                ", time='" + time + '\'' +
                ", bib_url='" + bib_url + '\'' +
                ", bib_source='" + bib_source + '\'' +
                ", authors=" + authors +
                ", keywords=" + keywords +
                '}';
    }
}
