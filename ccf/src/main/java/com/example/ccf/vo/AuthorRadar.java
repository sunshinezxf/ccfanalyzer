package com.example.ccf.vo;

public class AuthorRadar {

    private double aveArticleNum;

    private double maxArticleNum;

    private double aveCitationNum;

    private double maxCitationNum;

    private double aveAuthorCitation;

    private int maxAuthorCitation;

    private double aveRelation;

    private double maxRelation;

    private double aveYearArticleNum;

    private int maxYearArticleNum;

    public double getAveArticleNum() {
        return aveArticleNum;
    }

    public void setAveArticleNum(double aveArticleNum) {
        this.aveArticleNum = aveArticleNum;
    }

    public double getMaxArticleNum() {
        return maxArticleNum;
    }

    public void setMaxArticleNum(double maxArticleNum) {
        this.maxArticleNum = maxArticleNum;
    }

    public double getAveCitationNum() {
        return aveCitationNum;
    }

    public void setAveCitationNum(double aveCitationNum) {
        this.aveCitationNum = aveCitationNum;
    }

    public double getMaxCitationNum() {
        return maxCitationNum;
    }

    public void setMaxCitationNum(double maxCitationNum) {
        this.maxCitationNum = maxCitationNum;
    }

    public double getAveAuthorCitation() {
        return aveAuthorCitation;
    }

    public void setAveAuthorCitation(double aveAuthorCitation) {
        this.aveAuthorCitation = aveAuthorCitation;
    }

    public int getMaxAuthorCitation() {
        return maxAuthorCitation;
    }

    public void setMaxAuthorCitation(int maxAuthorCitation) {
        this.maxAuthorCitation = maxAuthorCitation;
    }

    public double getAveRelation() {
        return aveRelation;
    }

    public void setAveRelation(double aveRelation) {
        this.aveRelation = aveRelation;
    }

    public double getMaxRelation() {
        return maxRelation;
    }

    public void setMaxRelation(double maxRelation) {
        this.maxRelation = maxRelation;
    }

    public double getAveYearArticleNum() {
        return aveYearArticleNum;
    }

    public void setAveYearArticleNum(double aveYearArticleNum) {
        this.aveYearArticleNum = aveYearArticleNum;
    }

    public int getMaxYearArticleNum() {
        return maxYearArticleNum;
    }

    public void setMaxYearArticleNum(int maxYearArticleNum) {
        this.maxYearArticleNum = maxYearArticleNum;
    }

    @Override
    public String toString() {
        return "AuthorRadar{" +
                "aveArticleNum=" + aveArticleNum +
                ", maxArticleNum=" + maxArticleNum +
                ", aveCitationNum=" + aveCitationNum +
                ", maxCitationNum=" + maxCitationNum +
                ", aveAuthorCitation=" + aveAuthorCitation +
                ", maxAuthorCitation=" + maxAuthorCitation +
                ", aveRelation=" + aveRelation +
                ", maxRelation=" + maxRelation +
                ", aveYearArticleNum=" + aveYearArticleNum +
                ", maxYearArticleNum=" + maxYearArticleNum +
                '}';
    }
}
