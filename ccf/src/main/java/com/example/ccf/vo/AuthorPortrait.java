package com.example.ccf.vo;

import com.example.ccf.vo.Affiliation;

import java.util.Arrays;
import java.util.List;

public class AuthorPortrait {

    private int authorId;

    private String name;

    private List<Affiliation> affiliations;

    private String[] conferences;

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

    public List<Affiliation> getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(List<Affiliation> affiliations) {
        this.affiliations = affiliations;
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

    @Override
    public String toString() {
        return "AuthorPortrait{" +
                "authorId=" + authorId +
                ", name='" + name + '\'' +
                ", affiliations=" + affiliations +
                ", conferences=" + Arrays.toString(conferences) +
                ", articleNum=" + articleNum +
                ", articleCitationNum=" + articleCitationNum +
                '}';
    }
}
