package com.example.ccf.vo;

import java.util.List;

public class relatedPaper {

    private int id;

    private String name;

    private List<AuthorOmit> authorOmits;

    private List<AffiliationOmit> affiliationOmits;

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

    public List<AuthorOmit> getAuthorOmits() {
        return authorOmits;
    }

    public void setAuthorOmits(List<AuthorOmit> authorOmits) {
        this.authorOmits = authorOmits;
    }

    public List<AffiliationOmit> getAffiliationOmits() {
        return affiliationOmits;
    }

    public void setAffiliationOmits(List<AffiliationOmit> affiliationOmits) {
        this.affiliationOmits = affiliationOmits;
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
                ", authors=" + authorOmits +
                ", affiliations=" + affiliationOmits +
                ", keywords=" + keywords +
                ", summary='" + summary + '\'' +
                ", publication='" + publication + '\'' +
                ", citationCnt=" + citationCnt +
                '}';
    }
}
