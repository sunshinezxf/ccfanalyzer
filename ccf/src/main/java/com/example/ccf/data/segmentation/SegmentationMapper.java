package com.example.ccf.data.segmentation;
import com.example.ccf.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SegmentationMapper {
    /**
     * 形成单个标题关键词和论文id的对应形式需要获得的标题信息
     * @param start_id
     * @return
     */
    List<SegmentationTitle> get_title(@Param("start_id") int start_id);
    /**
     * 插入论文id和分词的对应形式形成索引
     * @param
     * @return
     */
    void insert_segmentation_title(List<SegmentationTitle> segmentationTitle);

    /**
     * 形成论文id和关键词的对应形式需要获得关键词对应关系
     * @param start_id
     * @return
     */
    List<KeywordInf> get_keyword(@Param("start_id") int start_id);
    /**
     * 形成论文id和关键词的对应形式需要获得关键词
     * @param
     * @return
     */
    List<KeywordInf> get_keywords();


    /**
     * 插入关键词形成索引
     * @param
     * @return
     */
    void insert_keyword(List<KeywordInf> keywordInf);

}
