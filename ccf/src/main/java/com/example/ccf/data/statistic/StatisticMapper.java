package com.example.ccf.data.statistic;

import com.example.ccf.po.statistic.Crawl;
import com.example.ccf.po.statistic.Statistic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StatisticMapper {

    Statistic getStatistic();

    List<Crawl> getCrawlStatistic();
}
