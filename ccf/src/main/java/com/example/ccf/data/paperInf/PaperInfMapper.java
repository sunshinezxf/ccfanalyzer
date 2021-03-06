package com.example.ccf.data.paperInf;
import com.example.ccf.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaperInfMapper {
    /**
     * 根据id获得论文信息
     * @param paper_id
     * @return
     */
    PaperInfOne get_Inf(@Param("paper_id") int paper_id);
    /**
     * 根据论文获得引用数
     * @param paper_id
     * @return
     */
   int get_Ref_Num(@Param("paper_id") int paper_id);
    /**
     * 根据论文获得引用信息
     * @param paper_id
     * @return
     */
    String get_Ref(@Param("paper_id") int paper_id);
    /**
     * 根据前缀匹配作者
     * @param input
     * @return
     */
    List<Authors> match_author(@Param("input") String input);
    /**
     * 根据前缀匹配会议
     * @param input
     * @return
     */
    List<String> match_conference(@Param("input") String input);
    /**
     * 根据前缀匹配机构
     * @param input
     * @return
     */
    List<Affiliations> match_affiliation(@Param("input") String input);
}
