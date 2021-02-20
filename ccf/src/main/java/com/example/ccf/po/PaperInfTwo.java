package com.example.ccf.po;
import java.util.List;
public class PaperInfTwo {
    private int paperId;
    private List<Authors> authors;
    private List<Affiliations> affiliations;
    private String publication;
    private String publicationYear;
    private int startPage;
    private int endPage;
    private String summary;
    private String doi;
    private String url;
    private int articleCitationCount;
    private List<String> keywords;
    private String title;

    public int getPaperId() {
        return paperId;
    }

    public void setPaperId(int paperId) {
        this.paperId = paperId;
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

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getDoi() {
        return doi;
    }

    public void setDoi(String doi) {
        this.doi = doi;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getArticleCitationCount() {
        return articleCitationCount;
    }

    public void setArticleCitationCount(int articleCitationCount) {
        this.articleCitationCount = articleCitationCount;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
