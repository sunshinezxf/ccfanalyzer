package com.example.ccf.po;

public class Author {

    private Integer author_id;

    private String author;

    private String affiliation;

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

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", author='" + author + '\'' +
                ", affiliation='" + affiliation + '\'' +
                '}';
    }
}
