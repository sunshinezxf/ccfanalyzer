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
}
