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
                '}';
    }
}

