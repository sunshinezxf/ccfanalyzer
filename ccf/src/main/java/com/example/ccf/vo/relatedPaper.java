package com.example.ccf.vo;

import java.util.List;

public class relatedPaper {

    private int id;

    private String name;

    private List<Author> authors;

    private List<Affiliation> affiliations;

    private List<String> keywords;

    private String summary;

    private String publication;

    private int citationCnt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<Affiliation> getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(List<Affiliation> affiliations) {
        this.affiliations = affiliations;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public int getCitationCnt() {
        return citationCnt;
    }

    public void setCitationCnt(int citationCnt) {
        this.citationCnt = citationCnt;
    }

    @Override
    public String toString() {
        return "relatedPaper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authors=" + authors +
                ", affiliations=" + affiliations +
                ", keywords=" + keywords +
                ", summary='" + summary + '\'' +
                ", publication='" + publication + '\'' +
                ", citationCnt=" + citationCnt +
                '}';
    }
}
