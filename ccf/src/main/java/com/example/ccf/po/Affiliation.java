package com.example.ccf.po;

public class Affiliation {

    private int affiliation_id;

    private String affiliation;

    public int getAffiliation_id() {
        return affiliation_id;
    }

    public void setAffiliation_id(int affiliation_id) {
        this.affiliation_id = affiliation_id;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    @Override
    public String toString() {
        return "Affiliation{" +
                "affiliation_id=" + affiliation_id +
                ", affiliation='" + affiliation + '\'' +
                '}';
    }
}
