package com.example.ccf.vo;

import java.util.List;

public class AuthorPortrait {

    private int authorId;

    private String name;

    private List<AffiliationOmit> affiliations;

    private List<ConferenceOmit> conferences;

    private int articleNum;

    private int articleCitationNum;

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AffiliationOmit> getAffiliationOmits() {
        return affiliations;
    }

    public void setAffiliationOmits(List<AffiliationOmit> affiliationOmits) {
        this.affiliations = affiliationOmits;
    }

    public List<AffiliationOmit> getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(List<AffiliationOmit> affiliations) {
        this.affiliations = affiliations;
    }

    public List<ConferenceOmit> getConferences() {
        return conferences;
    }

    public void setConferences(List<ConferenceOmit> conferences) {
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

    @Override
    public String toString() {
        return "AuthorPortrait{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", affiliations=" + affiliations +
                ", conferences=" + conferences +
                ", articleNum=" + articleNum +
                ", articleCitationNum=" + articleCitationNum +
                '}';
    }
}
