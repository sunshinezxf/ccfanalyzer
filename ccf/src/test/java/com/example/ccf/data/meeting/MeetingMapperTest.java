package com.example.ccf.data.meeting;

import com.example.ccf.data.ConnectTest;
import com.example.ccf.po.Meeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MeetingMapperTest {

    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private MeetingMapper meetingMapper;

    @Test
    public void meetingTest(){
        Meeting meeting=meetingMapper.getMeetingById(1);
        logger.info(meeting.toString());
    }
}
