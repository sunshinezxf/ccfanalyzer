package com.example.ccf.data.paper_upload;
import com.example.ccf.vo.Private_Author;
import com.example.ccf.vo.Private_paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface PaperUploadMapper {
    int insert_private_paper(Private_paper upload_paper);
    void insert_team_paper(@Param("team_id") int team_id,@Param("paper_id") int paper_id);
    void insert_user_paper(@Param("user_id") int user_id,@Param("paper_id") int paper_id);
    void insert_paper_author(List<Private_Author> private_authors);
    void alter_private_paper(Private_paper upload_paper);
    void delete_private_paper_authors(@Param("paper_id") int paper_id);
}
