package com.example.ccf.po;

public class Affiliation {

    private int affiliation_id;

    private String affiliation;

    private int article_num;

    private int article_citation_num;

    private int author_num;

    public int getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(int affiliation_id) {
        this.affiliation_id = affiliation_id;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
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

    @Override
    public String toString() {
        return "Affiliation{" +
                "affiliation_id=" + affiliation_id +
                ", affiliation='" + affiliation + '\'' +
                ", article_num=" + article_num +
                ", article_citation_num=" + article_citation_num +
                ", author_num=" + author_num +
                '}';
    }
}
