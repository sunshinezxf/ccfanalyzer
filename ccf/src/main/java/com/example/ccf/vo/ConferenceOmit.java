package com.example.ccf.vo;

public class ConferenceOmit {

    private int conferenceId;

    private String name;

    public int getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ConferenceOmit{" +
                "conferenceId=" + conferenceId +
                ", name='" + name + '\'' +
                '}';
    }
}
