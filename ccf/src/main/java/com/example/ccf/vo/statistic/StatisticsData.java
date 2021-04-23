package com.example.ccf.vo.statistic;

public class StatisticsData {

    private int authorNum;

    private int affiliationNum;

    private int paperNum;

    private int allArticleCitationCount;

    public int getAuthorNum() {
        return authorNum;
    }

    public void setAuthorNum(int authorNum) {
        this.authorNum = authorNum;
    }

    public int getAffiliationNum() {
        return affiliationNum;
    }

    public void setAffiliationNum(int affiliationNum) {
        this.affiliationNum = affiliationNum;
    }

    public int getPaperNum() {
        return paperNum;
    }

    public void setPaperNum(int paperNum) {
        this.paperNum = paperNum;
    }

    public int getAllArticleCitationCount() {
        return allArticleCitationCount;
    }

    public void setAllArticleCitationCount(int allArticleCitationCount) {
        this.allArticleCitationCount = allArticleCitationCount;
    }

    @Override
    public String toString() {
        return "StatisticsData{" +
                "authorNum=" + authorNum +
                ", affiliationNum=" + affiliationNum +
                ", paperNum=" + paperNum +
                ", allArticleCitationCount=" + allArticleCitationCount +
                '}';
    }
}
