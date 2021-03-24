package com.example.ccf.data.privatePaper;

import com.example.ccf.po.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PrivatePaperMapper {

    Paper getPrivatePaperById(@Param("user_id")int user_id);

    Paper getTeamPaperById(@Param("user_id")int user_id);

    int deletePaper(@Param("paper_id")int paper_id);
}
