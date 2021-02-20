package com.example.ccf.po;
import java.util.List;
public class SearchResultNum {
    private List<SearchResultForm> paperBriefInfoVOList;
    private int totalNum;

    public List<SearchResultForm> getPaperBriefInfoVOList() {
        return paperBriefInfoVOList;
    }

    public void setPaperBriefInfoVOList(List<SearchResultForm> paperBriefInfoVOList) {
        this.paperBriefInfoVOList = paperBriefInfoVOList;
    }

    public int getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(int totalNum) {
        this.totalNum = totalNum;
    }
}
