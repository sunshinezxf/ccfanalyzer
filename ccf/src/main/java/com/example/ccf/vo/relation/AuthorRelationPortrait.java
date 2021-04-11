package com.example.ccf.vo.relation;

import java.util.List;

public class AuthorRelationPortrait {

    private List<AuthorInfo> authors;

    private List<Connection> connections;

    public List<AuthorInfo> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorInfo> authors) {
        this.authors = authors;
    }

    public List<Connection> getConnections() {
        return connections;
    }

    public void setConnections(List<Connection> connections) {
        this.connections = connections;
    }

    @Override
    public String toString() {
        return "AuthorRelationPortrait{" +
                "authors=" + authors +
                ", connections=" + connections +
                '}';
    }
}
