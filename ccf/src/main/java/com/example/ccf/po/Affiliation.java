package com.example.ccf.po;

public class Affiliation {

    private int affiliation_id;

    private String affiliation;

    private int article_num;

    private int article_citation_num;

    private int author_num;

    private double ave_affiliation_citation;

    private int max_affiliation_citation;

    private double ave_affiliation_article;

    private int max_affiliation_article;

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

    public double getAve_affiliation_citation() {
        return ave_affiliation_citation;
    }

    public void setAve_affiliation_citation(double ave_affiliation_citation) {
        this.ave_affiliation_citation = ave_affiliation_citation;
    }

    public int getMax_affiliation_citation() {
        return max_affiliation_citation;
    }

    public void setMax_affiliation_citation(int max_affiliation_citation) {
        this.max_affiliation_citation = max_affiliation_citation;
    }

    public double getAve_affiliation_article() {
        return ave_affiliation_article;
    }

    public void setAve_affiliation_article(double ave_affiliation_article) {
        this.ave_affiliation_article = ave_affiliation_article;
    }

    public int getMax_affiliation_article() {
        return max_affiliation_article;
    }

    public void setMax_affiliation_article(int max_affiliation_article) {
        this.max_affiliation_article = max_affiliation_article;
    }

    @Override
    public String toString() {
        return "Affiliation{" +
                "affiliation_id=" + affiliation_id +
                ", affiliation='" + affiliation + '\'' +
                ", article_num=" + article_num +
                ", article_citation_num=" + article_citation_num +
                ", author_num=" + author_num +
                ", ave_affiliation_citation=" + ave_affiliation_citation +
                ", max_affiliation_citation=" + max_affiliation_citation +
                ", ave_affiliation_article=" + ave_affiliation_article +
                ", max_affiliation_article=" + max_affiliation_article +
                '}';
    }
}
