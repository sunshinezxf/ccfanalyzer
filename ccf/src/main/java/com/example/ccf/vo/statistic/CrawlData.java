package com.example.ccf.vo.statistic;

public class CrawlData {

    private String requestBytes;

    private String requestCount;

    private String countGET;

    private String count200;

    private String count301;

    private String count302;

    private String count40x;

    private String finishReason;

    private String finishTime;

    private String startTime;

    private String paperCount;

    private String meetingCount;


    public String getRequestBytes() {
        return requestBytes;
    }

    public void setRequestBytes(String requestBytes) {
        this.requestBytes = requestBytes;
    }

    public String getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(String requestCount) {
        this.requestCount = requestCount;
    }

    public String getCountGET() {
        return countGET;
    }

    public void setCountGET(String countGET) {
        this.countGET = countGET;
    }

    public String getCount200() {
        return count200;
    }

    public void setCount200(String count200) {
        this.count200 = count200;
    }

    public String getCount301() {
        return count301;
    }

    public void setCount301(String count301) {
        this.count301 = count301;
    }

    public String getCount302() {
        return count302;
    }

    public void setCount302(String count302) {
        this.count302 = count302;
    }

    public String getCount40x() {
        return count40x;
    }

    public void setCount40x(String count40x) {
        this.count40x = count40x;
    }

    public String getFinishReason() {
        return finishReason;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(String paperCount) {
        this.paperCount = paperCount;
    }

    public String getMeetingCount() {
        return meetingCount;
    }

    public void setMeetingCount(String meetingCount) {
        this.meetingCount = meetingCount;
    }

    @Override
    public String toString() {
        return "CrawlData{" +
                "requestBytes='" + requestBytes + '\'' +
                ", requestCount='" + requestCount + '\'' +
                ", countGET='" + countGET + '\'' +
                ", count200='" + count200 + '\'' +
                ", count301='" + count301 + '\'' +
                ", count302='" + count302 + '\'' +
                ", count40x='" + count40x + '\'' +
                ", finishReason='" + finishReason + '\'' +
                ", finishTime='" + finishTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", paperCount='" + paperCount + '\'' +
                ", meetingCount='" + meetingCount + '\'' +
                '}';
    }
}
