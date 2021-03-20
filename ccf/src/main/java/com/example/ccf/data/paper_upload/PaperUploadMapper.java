package com.example.ccf.data.paper_upload;
import com.example.ccf.vo.Private_paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;



@Mapper
public interface PaperUploadMapper {
    int insert_private_paper(Private_paper upload_paper);
    void insert_team_paper(@Param("team_id") int team_id,@Param("paper_id") int paper_id);
    void insert_user_paper(@Param("user_id") int user_id,@Param("paper_id") int paper_id);
}
