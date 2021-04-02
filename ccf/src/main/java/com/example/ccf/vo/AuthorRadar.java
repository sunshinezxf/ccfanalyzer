package com.example.ccf.vo;

public class AuthorRadar {

    private double aveArticleNum;

    private double maxArticleNum;

    private double aveCitationNum;

    private double maxCitationNum;

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

    @Override
    public String toString() {
        return "affiliationRadar{" +
                "aveArticleNum=" + aveArticleNum +
                ", maxArticleNum=" + maxArticleNum +
                ", aveCitationNum=" + aveCitationNum +
                ", maxCitationNum=" + maxCitationNum +
                '}';
    }
}
