package com.example.ccf.vo;

import java.util.List;

public class AuthorOmit {

    private int id;

    private String name;

    private List<AffiliationOmit> affiliations;

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

    public List<AffiliationOmit> getAffiliations() {
        return affiliations;
    }

    public void setAffiliations(List<AffiliationOmit> affiliations) {
        this.affiliations = affiliations;
    }

    @Override
    public String toString() {
        return "AuthorOmit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", affiliations=" + affiliations +
                '}';
    }
}
