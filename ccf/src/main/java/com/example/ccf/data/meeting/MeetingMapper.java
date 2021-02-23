package com.example.ccf.data.meeting;


import com.example.ccf.po.Meeting;
import com.example.ccf.po.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MeetingMapper {

    Meeting getMeetingById(@Param("meeting_id")int meeting_id);

    // index已经x10 -> offset
    List<Paper> getMeetingPaper(@Param("meeting_id")int meeting_id, @Param("offset")int offset);
}
