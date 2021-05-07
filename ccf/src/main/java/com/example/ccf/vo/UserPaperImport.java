package com.example.ccf.vo;

import java.util.List;

public class UserPaperImport {
    private int paper_id;
    private List<String> authors;
    private String title;
    private String abstracts;
    private String doi;
    private int citation;
    private String book_title;
    private String pages;
    private String publisher;
    private String year;
    private String url;
    private String time;
    private String bib_url;
    private String bib_source;
    private String token;
    public Private_paper change(){
        Private_paper p=new Private_paper();
        p.setAuthors(authors);
        p.setAbstracts(abstracts);
        p.setPaper_id(paper_id);
        p.setTitle(title);
        p.setDoi(doi);
        p.setCitation(citation);
        p.setBook_title(book_title);
        p.setPages(pages);
        p.setPublisher(publisher);
        p.setYear(year);
        p.setUrl(url);
        p.setTime(time);
        p.setBib_url(bib_url);
        p.setBib_source(bib_source);
        return  p;
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public int getCitation() {
        return citation;
    }

    public void setCitation(int citation) {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
