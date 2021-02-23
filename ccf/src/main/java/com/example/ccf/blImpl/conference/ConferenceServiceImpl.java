package com.example.ccf.blImpl.conference;

import com.example.ccf.bl.ConferenceService;
import com.example.ccf.blImpl.paper.PaperBlService;
import com.example.ccf.data.meeting.MeetingMapper;
import com.example.ccf.po.Meeting;
import com.example.ccf.po.Paper;
import com.example.ccf.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    private MeetingMapper meetingMapper;
    private PaperBlService paperBlService;

    @Autowired
    public void DI(MeetingMapper meetingMapper,PaperBlService paperBlService){
        this.meetingMapper=meetingMapper;
        this.paperBlService=paperBlService;
    }

    @Override
    public ResponseVO getConferencePortrait(int conferenceId) {

        ConferencePortrait conferencePortrait=new ConferencePortrait();

        Meeting meeting=meetingMapper.getMeetingById(conferenceId);

        conferencePortrait.setName(meeting.getTitle());
        conferencePortrait.setAffiliationNum(meeting.getAffiliation_num());
        conferencePortrait.setArticleCitationNum(meeting.getArticle_citation_num());
        conferencePortrait.setArticleNum(meeting.getArticle_num());
        conferencePortrait.setAuthorNum(meeting.getAuthor_num());

        return ResponseVO.buildSuccess(conferencePortrait);
    }

    @Override
    public ResponseVO getConferenceRelatedPapers(int conferenceId,int index) {

        List<Paper> papers=meetingMapper.getMeetingPaper(conferenceId,index*10);
        List<RelatedPaper> paperBriefInfoVOList=paperBlService.getRelatedPaper(papers);

        return ResponseVO.buildSuccess(paperBriefInfoVOList);
    }
}
