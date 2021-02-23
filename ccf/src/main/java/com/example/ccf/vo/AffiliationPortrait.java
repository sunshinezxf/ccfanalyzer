package com.example.ccf.vo;

import java.util.Arrays;

public class AffiliationPortrait {

    private int affiliationId;

    private String name;

    private ConferenceOmit[] conferences;

    private int articleNum;

    private int articleCitationNum;

    private int authorNum;

    public int getAffiliationId() {
        return affiliationId;
    }

    public void setAffiliationId(int affiliationId) {
        this.affiliationId = affiliationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConferenceOmit[] getConferences() {
        return conferences;
    }

    public void setConferences(ConferenceOmit[] conferences) {
        this.conferences = conferences;
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

    public int getAuthorNum() {
        return authorNum;
    }

    public void setAuthorNum(int authorNum) {
        this.authorNum = authorNum;
    }

    @Override
    public String toString() {
        return "AffiliationPortrait{" +
                "affiliationId=" + affiliationId +
                ", name='" + name + '\'' +
                ", conferences=" + Arrays.toString(conferences) +
                ", articleNum=" + articleNum +
                ", articleCitationNum=" + articleCitationNum +
                ", authorNum=" + authorNum +
                '}';
    }
}
