package com.example.ccf.vo;

public class AffiliationRadar {

    private double aveArticleNum;

    private double maxArticleNum;

    private double aveCitationNum;

    private double maxCitationNum;

    private double aveAuthorNum;

    private double maxAuthorNum;

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

    public double getAveAuthorNum() {
        return aveAuthorNum;
    }

    public void setAveAuthorNum(double aveAuthorNum) {
        this.aveAuthorNum = aveAuthorNum;
    }

    public double getMaxAuthorNum() {
        return maxAuthorNum;
    }

    public void setMaxAuthorNum(double maxAuthorNum) {
        this.maxAuthorNum = maxAuthorNum;
    }

    @Override
    public String toString() {
        return "AffiliationRadar{" +
                "aveArticleNum=" + aveArticleNum +
                ", maxArticleNum=" + maxArticleNum +
                ", aveCitationNum=" + aveCitationNum +
                ", maxCitationNum=" + maxCitationNum +
                ", aveAuthorNum=" + aveAuthorNum +
                ", maxAuthorNum=" + maxAuthorNum +
                '}';
    }
}
