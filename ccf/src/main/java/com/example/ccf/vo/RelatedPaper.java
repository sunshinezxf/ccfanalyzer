package com.example.ccf.vo;

import java.util.List;

public class RelatedPaper {

    private int paperId;

    private String title;

    private List<AuthorOmit> authors;

    private List<String> keywords;

    private String Abstract;

    private String publication;

    private int citationCnt;

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

    public List<AuthorOmit> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorOmit> authors) {
        this.authors = authors;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getAbstract() {
        return Abstract;
    }

    public void setAbstract(String anAbstract) {
        Abstract = anAbstract;
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
        return "RelatedPaper{" +
                "paperId=" + paperId +
                ", title='" + title + '\'' +
                ", authors=" + authors +
                ", keywords=" + keywords +
                ", Abstract='" + Abstract + '\'' +
                ", publication='" + publication + '\'' +
                ", citationCnt=" + citationCnt +
                '}';
    }
}
