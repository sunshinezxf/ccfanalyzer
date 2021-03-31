package com.example.ccf.data.share;
import com.example.ccf.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShareMapper {
    void share_paper(@Param("user_id") int user_id,@Param("paper_id") int paper_id);
    int share_right(@Param("user_id") int user_id,@Param("paper_id") int paper_id);
    Integer find_id(@Param("user_name") String user_name);
    List<Private_Paper_Must> receiver_list(@Param("user_id") int user_id);
    Integer first_share(@Param("user_id") int user_id,@Param("paper_id") int paper_id);
    List<String> authors_get(@Param("paper_id") int paper_id);
}
