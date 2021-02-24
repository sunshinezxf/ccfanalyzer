package com.example.ccf.po;

public class Meeting {

    private Integer meeting_id;

    private String title;

    private String publisher;

    private String year;

    private String url;

    private String doi;

    private String isbn;

    private String time;

    private String bib_url;

    private String bib_source;

    private int article_num;

    private int article_citation_num;

    private int author_num;

    private int affiliation_num;

    public Integer getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(Integer meeting_id) {
        this.meeting_id = meeting_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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

    public int getArticle_num() {
        return article_num;
    }

    public void setArticle_num(int article_num) {
        this.article_num = article_num;
    }

    public int getArticle_citation_num() {
        return article_citation_num;
    }

    public void setArticle_citation_num(int article_citation_num) {
        this.article_citation_num = article_citation_num;
    }

    public int getAuthor_num() {
        return author_num;
    }

    public void setAuthor_num(int author_num) {
        this.author_num = author_num;
    }

    public int getAffiliation_num() {
        return affiliation_num;
    }

    public void setAffiliation_num(int affiliation_num) {
        this.affiliation_num = affiliation_num;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "meeting_id=" + meeting_id +
                ", title='" + title + '\'' +
                ", publisher='" + publisher + '\'' +
                ", year='" + year + '\'' +
                ", url='" + url + '\'' +
                ", doi='" + doi + '\'' +
                ", isbn='" + isbn + '\'' +
                ", time='" + time + '\'' +
                ", bib_url='" + bib_url + '\'' +
                ", bib_source='" + bib_source + '\'' +
                ", article_num=" + article_num +
                ", article_citation_num=" + article_citation_num +
                ", author_num=" + author_num +
                ", affiliation_num=" + affiliation_num +
                '}';
    }
}

