package com.example.ccf.data.statistic;

import com.example.ccf.po.Statistic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface StatisticMapper {

    Statistic getStatistic();
}
