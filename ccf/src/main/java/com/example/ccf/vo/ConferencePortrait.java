package com.example.ccf.vo;

public class ConferencePortrait {
    private String name;

    private int authorNum;

    private int affiliationNum;

    private int articleNum;

    private int articleCitationNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    public int getArticleCitationNum() {
        return articleCitationNum;
    }

    public void setArticleCitationNum(int articleCitationNum) {
        this.articleCitationNum = articleCitationNum;
    }

    @Override
    public String toString() {
        return "conferencePortrait{" +
                "name='" + name + '\'' +
                ", authorNum=" + authorNum +
                ", affiliationNum=" + affiliationNum +
                ", articleNum=" + articleNum +
                ", articleCitationNum=" + articleCitationNum +
                '}';
    }

}
