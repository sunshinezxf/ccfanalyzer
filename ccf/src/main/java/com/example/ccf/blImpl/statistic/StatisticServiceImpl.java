package com.example.ccf.blImpl.statistic;

import com.example.ccf.bl.StatisticService;
import com.example.ccf.data.statistic.StatisticMapper;
import com.example.ccf.po.Statistic;
import com.example.ccf.vo.ResponseVO;
import com.example.ccf.vo.StatisticsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatisticServiceImpl implements StatisticService {

    private StatisticMapper statisticMapper;

    @Autowired
    public void DI(StatisticMapper statisticMapper){
        this.statisticMapper=statisticMapper;
    }

    @Override
    public ResponseVO getStatisticData() {

        Statistic statistic=statisticMapper.getStatistic();
        StatisticsData statisticsData=new StatisticsData();

        statisticsData.setPaperNum(statistic.getPaper_num());
        statisticsData.setAffiliationNum(statistic.getAffiliation_num());
        statisticsData.setAllArticleCitationCount(statistic.getCitation_num());
        statisticsData.setAuthorNum(statistic.getAuthor_num());

        return ResponseVO.buildSuccess(statisticsData);
    }
}
