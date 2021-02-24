package com.example.ccf.po;

import java.util.List;

public class SearchResultForm {
    private int paperId;
    private String title;
    private List<Authors> authors;
    private List<Affiliations> affiliations;
    private List<String> keywords;
    private String summary;
    private String publication;

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Authors> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Authors> authors) {
        this.authors = authors;
    }

    public List<Affiliations> getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(List<Affiliations> affiliations) {
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
}
