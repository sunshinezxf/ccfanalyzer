package com.example.ccf.data.paper;

import com.example.ccf.po.InfoPaper;
import com.example.ccf.po.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface PaperMapper {

    Paper getPaperById(@Param("paper_id")int paper_id);

    InfoPaper getInfoPaper(@Param("paper_id")int paper_id);

}
