package com.example.ccf.data.meeting;

import com.example.ccf.bl.ConferenceService;
import com.example.ccf.data.ConnectTest;
import com.example.ccf.po.Meeting;
import com.example.ccf.vo.ResponseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingMapperTest {

    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private MeetingMapper meetingMapper;
    @Autowired
    private ConferenceService conferenceService;

    @Test
    public void meetingTest(){
        Meeting meeting=meetingMapper.getMeetingById(1);
        logger.info(meeting.toString());
    }

    @Test
    public void conferenceServiceTest(){

        ResponseVO responseVO=conferenceService.getConferenceRelatedPapers(1,0);
        logger.info(responseVO.getContent().toString());
    }

    @Test
    public void getMeetingByTitle(){
        List<String> titles= Arrays.asList("23", "{ISSTA} '20: 29th {ACM} {SIGSOFT} International Symposium on Software " +
                "Testing and Analysis, Virtual Event, USA, July 18-22, 2020", "123123","qwe","wqerwqer");
        List<Meeting> meetings=meetingMapper.getMeetingByTitle(titles);
        logger.info(meetings.toString());
    }
}
