package com.example.ccf.vo;

import java.util.Arrays;

public class AffiliationPortrait {

    private int affiliationId;

    private String name;

    private String authors;

    private String[] conferences;

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

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String[] getConferences() {
        return conferences;
    }

    public void setConferences(String[] conferences) {
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
        return "affiliationPortrait{" +
                "affiliationId=" + affiliationId +
                ", name='" + name + '\'' +
                ", authors='" + authors + '\'' +
                ", conferences=" + Arrays.toString(conferences) +
                ", articleNum=" + articleNum +
                ", articleCitationNum=" + articleCitationNum +
                ", authorNum=" + authorNum +
                '}';
    }
}
