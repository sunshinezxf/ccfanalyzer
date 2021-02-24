package com.example.ccf.data.search;
import com.example.ccf.po.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SearchMapper {
    /**
     * 根据切词获得id
     * @param word
     * @return
     */
    List<Integer> get_id(@Param("word") String word);
    /**
     * 获得论文部分信息
     * @param
     * @return
     */
    List<SearchResultForm> get_Inf(List<Integer> ids);
    /**
     * 获得作者信息
     * @param paper_id
     * @return
     */
    List<Authors> get_author(@Param("paper_id") int paper_id);
    /**
     * 获得机构信息
     * @param paper_id
     * @return
     */
    List<Affiliations> get_affiliation(@Param("paper_id") int paper_id);
    /**
     * 获得关键词
     * @param paper_id
     * @return
     */
    List<String> get_keyword(@Param("paper_id") int paper_id);
    /**
     * 根据作者获得id
     * @param author
     * @return
     */
    List<Integer> author_to_id(@Param("author") String author);
    /**
     * 根据机构获得id
     * @param affiliation
     * @return
     */
    List<Integer> affiliation_to_id(@Param("affiliation") String affiliation);
    /**
     * 根据关键词获得id
     * @param keyword
     * @return
     */
    List<Integer> keyword_to_id(@Param("keyword") String keyword);
    /**
     * 根据年份获得id
     * @param
     * @return
     */
    List<Integer> year_to_id(List<String> year);
    /**
     * 根据会议获得id
     * @param conference
     * @return
     */
    List<Integer> conference_to_id(@Param("conference") String conference);
}
