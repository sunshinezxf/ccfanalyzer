package com.example.ccf.po.statistic;

public class Statistic {

    private int author_num;

    private int affiliation_num;

    private int meeting_num;

    private int paper_num;

    private int citation_num;

    private double author_ave_article_num;

    private double author_max_article_num;

    private double author_ave_citation_num;

    private double author_max_citation_num;

    private double affiliation_ave_article_num;

    private double affiliation_max_article_num;

    private double affiliation_ave_citation_num;

    private double affiliation_max_citation_num;

    private double affiliation_ave_author_num;

    private double affiliation_max_author_num;


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

    public int getMeeting_num() {
        return meeting_num;
    }

    public void setMeeting_num(int meeting_num) {
        this.meeting_num = meeting_num;
    }

    public int getPaper_num() {
        return paper_num;
    }

    public void setPaper_num(int paper_num) {
        this.paper_num = paper_num;
    }

    public int getCitation_num() {
        return citation_num;
    }

    public void setCitation_num(int citation_num) {
        this.citation_num = citation_num;
    }

    public double getAuthor_ave_article_num() {
        return author_ave_article_num;
    }

    public void setAuthor_ave_article_num(double author_ave_article_num) {
        this.author_ave_article_num = author_ave_article_num;
    }

    public double getAuthor_max_article_num() {
        return author_max_article_num;
    }

    public void setAuthor_max_article_num(double author_max_article_num) {
        this.author_max_article_num = author_max_article_num;
    }

    public double getAuthor_ave_citation_num() {
        return author_ave_citation_num;
    }

    public void setAuthor_ave_citation_num(double author_ave_citation_num) {
        this.author_ave_citation_num = author_ave_citation_num;
    }

    public double getAuthor_max_citation_num() {
        return author_max_citation_num;
    }

    public void setAuthor_max_citation_num(double author_max_citation_num) {
        this.author_max_citation_num = author_max_citation_num;
    }

    public double getAffiliation_ave_article_num() {
        return affiliation_ave_article_num;
    }

    public void setAffiliation_ave_article_num(double affiliation_ave_article_num) {
        this.affiliation_ave_article_num = affiliation_ave_article_num;
    }

    public double getAffiliation_max_article_num() {
        return affiliation_max_article_num;
    }

    public void setAffiliation_max_article_num(double affiliation_max_article_num) {
        this.affiliation_max_article_num = affiliation_max_article_num;
    }

    public double getAffiliation_ave_citation_num() {
        return affiliation_ave_citation_num;
    }

    public void setAffiliation_ave_citation_num(double affiliation_ave_citation_num) {
        this.affiliation_ave_citation_num = affiliation_ave_citation_num;
    }

    public double getAffiliation_max_citation_num() {
        return affiliation_max_citation_num;
    }

    public void setAffiliation_max_citation_num(double affiliation_max_citation_num) {
        this.affiliation_max_citation_num = affiliation_max_citation_num;
    }

    public double getAffiliation_ave_author_num() {
        return affiliation_ave_author_num;
    }

    public void setAffiliation_ave_author_num(double affiliation_ave_author_num) {
        this.affiliation_ave_author_num = affiliation_ave_author_num;
    }

    public double getAffiliation_max_author_num() {
        return affiliation_max_author_num;
    }

    public void setAffiliation_max_author_num(double affiliation_max_author_num) {
        this.affiliation_max_author_num = affiliation_max_author_num;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "author_num=" + author_num +
                ", affiliation_num=" + affiliation_num +
                ", meeting_num=" + meeting_num +
                ", paper_num=" + paper_num +
                ", citation_num=" + citation_num +
                ", author_ave_article_num=" + author_ave_article_num +
                ", author_max_article_num=" + author_max_article_num +
                ", author_ave_citation_num=" + author_ave_citation_num +
                ", author_max_citation_num=" + author_max_citation_num +
                ", affiliation_ave_article_num=" + affiliation_ave_article_num +
                ", affiliation_max_article_num=" + affiliation_max_article_num +
                ", affiliation_ave_citation_num=" + affiliation_ave_citation_num +
                ", affiliation_max_citation_num=" + affiliation_max_citation_num +
                ", affiliation_ave_author_num=" + affiliation_ave_author_num +
                ", affiliation_max_author_num=" + affiliation_max_author_num +
                '}';
    }
}
