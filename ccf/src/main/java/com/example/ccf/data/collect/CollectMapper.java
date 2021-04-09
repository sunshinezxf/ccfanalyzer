package com.example.ccf.data.collect;
import com.example.ccf.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CollectMapper {
    void collect(@Param("user_id") int user_id,@Param("paper_id") int paper_id);
    void cancel_collect(@Param("user_id") int user_id,@Param("paper_id") int paper_id);
    List<Integer> collection_list(int user_id);
    int if_collect(@Param("user_id") int user_id,@Param("paper_id") int paper_id);
}