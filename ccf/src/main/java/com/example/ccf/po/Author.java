package com.example.ccf.po;

public class Author {

    private Integer author_id;

    private String author;

    private int article_num;

    private int article_citation_num;

    public int getArticle_num() {
        return article_num;
    }

    public void setArticle_num(int article_num) {
        this.article_num = article_num;
    }

    public int getArticle_citation_num() {
        return article_citation_num;
    }

    public void setArticle_citation_num(int article_citation_num) {
        this.article_citation_num = article_citation_num;
    }

    public Integer getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Integer author_id) {
        this.author_id = author_id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Author{" +
                "author_id=" + author_id +
                ", author='" + author + '\'' +
                ", article_num=" + article_num +
                ", article_citation_num=" + article_citation_num +
                '}';
    }
}
