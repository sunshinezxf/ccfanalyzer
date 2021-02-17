package com.example.ccf.po;

public class Author {

    private Integer author_id;

    private String author;

    private String affiliation_id;

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(String affiliation) {
        this.affiliation_id = affiliation;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", author='" + author + '\'' +
                ", affiliation_id='" + affiliation_id + '\'' +
                '}';
    }
}
