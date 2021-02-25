package com.example.ccf.po;

public class Statistic {

    private int author_num;

    private int affiliation_num;

    private int meeting_num;

    private int paper_num;

    private int citation_num;

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

    @Override
    public String toString() {
        return "Statistic{" +
                "author_num=" + author_num +
                ", affiliation_num=" + affiliation_num +
                ", meeting_num=" + meeting_num +
                ", paper_num=" + paper_num +
                ", citation_num=" + citation_num +
                '}';
    }
}
