package com.example.ccf.vo.relation;

public class Connection {

    private String source;

    private String target;

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }


    @Override
    public String toString() {
        return "Connection{" +
                "source='" + source + '\'' +
                ", target='" + target + '\'' +
                '}';
    }
}
