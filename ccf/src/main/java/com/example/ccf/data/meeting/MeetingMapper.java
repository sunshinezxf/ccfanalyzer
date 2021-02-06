package com.example.ccf.data.meeting;


import com.example.ccf.po.Meeting;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MeetingMapper {

    Meeting getMeetingById(@Param("meeting_id")int meeting_id);

}
