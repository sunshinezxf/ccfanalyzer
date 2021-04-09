package com.example.ccf.vo;

public class AffiliationRadar {

    private double aveArticleNum;

    private double maxArticleNum;

    private double aveCitationNum;

    private double maxCitationNum;

    private double aveAuthorNum;

    private double maxAuthorNum;

    // 本机构作者文章平均引用数
    private double aveAffiliationCitationNum;

    // 本机构作者文章最大引用数
    private int maxAffiliationCitationNum;

    // 本机构作者平均文章数
    private double aveAffiliationArticleNum;

    // 本机构作者最大文章数
    private int maxAffiliationArticleNum;

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

    public double getAveAffiliationCitationNum() {
        return aveAffiliationCitationNum;
    }

    public void setAveAffiliationCitationNum(double aveAffiliationCitationNum) {
        this.aveAffiliationCitationNum = aveAffiliationCitationNum;
    }

    public int getMaxAffiliationCitationNum() {
        return maxAffiliationCitationNum;
    }

    public void setMaxAffiliationCitationNum(int maxAffiliationCitationNum) {
        this.maxAffiliationCitationNum = maxAffiliationCitationNum;
    }

    public double getAveAffiliationArticleNum() {
        return aveAffiliationArticleNum;
    }

    public void setAveAffiliationArticleNum(double aveAffiliationArticleNum) {
        this.aveAffiliationArticleNum = aveAffiliationArticleNum;
    }

    public int getMaxAffiliationArticleNum() {
        return maxAffiliationArticleNum;
    }

    public void setMaxAffiliationArticleNum(int maxAffiliationArticleNum) {
        this.maxAffiliationArticleNum = maxAffiliationArticleNum;
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
                ", aveAffiliationCitationNum=" + aveAffiliationCitationNum +
                ", maxAffiliationCitationNum=" + maxAffiliationCitationNum +
                ", aveAffiliationArticleNum=" + aveAffiliationArticleNum +
                ", maxAffiliationArticleNum=" + maxAffiliationArticleNum +
                '}';
    }
}
