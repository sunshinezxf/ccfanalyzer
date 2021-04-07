package com.example.ccf.po;

public class AuthorRelation {

    private int relation_id;

    private int author_one_id;

    private int author_two_id;

    private int coop_time;

    public int getRelation_id() {
        return relation_id;
    }

    public void setRelation_id(int relation_id) {
        this.relation_id = relation_id;
    }

    public int getAuthor_one_id() {
        return author_one_id;
    }

    public void setAuthor_one_id(int author_one_id) {
        this.author_one_id = author_one_id;
    }

    public int getAuthor_two_id() {
        return author_two_id;
    }

    public void setAuthor_two_id(int author_two_id) {
        this.author_two_id = author_two_id;
    }

    public int getCoop_time() {
        return coop_time;
    }

    public void setCoop_time(int coop_time) {
        this.coop_time = coop_time;
    }

    @Override
    public String toString() {
        return "AuthorRelation{" +
                "relation_id=" + relation_id +
                ", author_one_id=" + author_one_id +
                ", author_two_id=" + author_two_id +
                ", coop_time=" + coop_time +
                '}';
    }
}
