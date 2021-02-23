package com.example.ccf.data.paper;

import com.example.ccf.po.Author;
import com.example.ccf.po.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PaperMapper {

    Paper getPaperById(@Param("paper_id")int paper_id);

    List<Author> getPaperAuthors(@Param("paper_id")int paper_id);

    List<String> getPaperKeywords(@Param("paper_id")int paper_id);
}
