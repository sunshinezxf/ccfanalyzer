package com.example.ccf.po.statistic;

public class Crawl {

    private String request_bytes;

    private String request_count;

    private String request_method_count_GET;

    private String response_status_count_200;

    private String response_status_count_301;

    private String response_status_count_302;

    private String response_status_count_40x;

    private String finish_reason;

    private String finish_time;

    private String start_time;

    private String paper_count;

    private String meeting_count;

    private int crawl_id;

    public String getRequest_bytes() {
        return request_bytes;
    }

    public void setRequest_bytes(String request_bytes) {
        this.request_bytes = request_bytes;
    }

    public String getRequest_count() {
        return request_count;
    }

    public void setRequest_count(String request_count) {
        this.request_count = request_count;
    }

    public String getRequest_method_count_GET() {
        return request_method_count_GET;
    }

    public void setRequest_method_count_GET(String request_method_count_GET) {
        this.request_method_count_GET = request_method_count_GET;
    }

    public String getResponse_status_count_200() {
        return response_status_count_200;
    }

    public void setResponse_status_count_200(String response_status_count_200) {
        this.response_status_count_200 = response_status_count_200;
    }

    public String getResponse_status_count_301() {
        return response_status_count_301;
    }

    public void setResponse_status_count_301(String response_status_count_301) {
        this.response_status_count_301 = response_status_count_301;
    }

    public String getResponse_status_count_302() {
        return response_status_count_302;
    }

    public void setResponse_status_count_302(String response_status_count_302) {
        this.response_status_count_302 = response_status_count_302;
    }

    public String getResponse_status_count_40x() {
        return response_status_count_40x;
    }

    public void setResponse_status_count_40x(String response_status_count_40x) {
        this.response_status_count_40x = response_status_count_40x;
    }

    public String getFinish_reason() {
        return finish_reason;
    }

    public void setFinish_reason(String finish_reason) {
        this.finish_reason = finish_reason;
    }

    public String getFinish_time() {
        return finish_time;
    }

    public void setFinish_time(String finish_time) {
        this.finish_time = finish_time;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getPaper_count() {
        return paper_count;
    }

    public void setPaper_count(String paper_count) {
        this.paper_count = paper_count;
    }

    public String getMeeting_count() {
        return meeting_count;
    }

    public void setMeeting_count(String meeting_count) {
        this.meeting_count = meeting_count;
    }

    public int getCrawl_id() {
        return crawl_id;
    }

    public void setCrawl_id(int crawl_id) {
        this.crawl_id = crawl_id;
    }

    @Override
    public String toString() {
        return "Crawl{" +
                "request_bytes='" + request_bytes + '\'' +
                ", request_count='" + request_count + '\'' +
                ", request_method_count_GET='" + request_method_count_GET + '\'' +
                ", response_status_count_200='" + response_status_count_200 + '\'' +
                ", response_status_count_301='" + response_status_count_301 + '\'' +
                ", response_status_count_302='" + response_status_count_302 + '\'' +
                ", response_status_count_40x='" + response_status_count_40x + '\'' +
                ", finish_reason='" + finish_reason + '\'' +
                ", finish_time='" + finish_time + '\'' +
                ", start_time='" + start_time + '\'' +
                ", paper_count='" + paper_count + '\'' +
                ", meeting_count='" + meeting_count + '\'' +
                ", crawl_id=" + crawl_id +
                '}';
    }
}
