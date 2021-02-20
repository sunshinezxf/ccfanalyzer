package com.example.ccf.blImpl;

import com.example.ccf.bl.ConferenceService;
import com.example.ccf.data.author.AuthorMapper;
import com.example.ccf.data.meeting.MeetingMapper;
import com.example.ccf.po.Meeting;
import com.example.ccf.vo.ConferencePortrait;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    private MeetingMapper meetingMapper;

    @Autowired
    public void DI(MeetingMapper meetingMapper){
        this.meetingMapper=meetingMapper;
    }

    @Override
    public ResponseVO getConferencePortrait(int conferenceId) {

        ConferencePortrait conferencePortrait=new ConferencePortrait();

        Meeting meeting=meetingMapper.getMeetingById(conferenceId);

        conferencePortrait.setName(meeting.getTitle());

        // TODO
        return ResponseVO.buildSuccess(conferencePortrait);
    }

    @Override
    public ResponseVO getConferenceRelatedPapers(int conferenceId,int index) {
        return null;
    }
}
