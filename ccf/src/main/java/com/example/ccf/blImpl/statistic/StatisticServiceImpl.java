package com.example.ccf.blImpl.statistic;

import com.example.ccf.bl.StatisticService;
import com.example.ccf.data.statistic.StatisticMapper;
import com.example.ccf.po.Statistic;
import com.example.ccf.vo.AffiliationRadar;
import com.example.ccf.vo.AuthorRadar;
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

    @Override
    public ResponseVO getAuthorRadar() {

        Statistic statistic=statisticMapper.getStatistic();
        AuthorRadar authorRadar=new AuthorRadar();

        authorRadar.setAveCitationNum(statistic.getAuthor_ave_citation_num());
        authorRadar.setMaxCitationNum(statistic.getAuthor_max_citation_num());
        authorRadar.setAveArticleNum(statistic.getAuthor_ave_article_num());
        authorRadar.setMaxArticleNum(statistic.getAuthor_max_article_num());

        return ResponseVO.buildSuccess(authorRadar);
    }

    @Override
    public ResponseVO getAffiliationRadar() {

        Statistic statistic=statisticMapper.getStatistic();
        AffiliationRadar affiliationRadar=new AffiliationRadar();

        affiliationRadar.setAveCitationNum(statistic.getAffiliation_ave_citation_num());
        affiliationRadar.setMaxCitationNum(statistic.getAffiliation_max_citation_num());
        affiliationRadar.setAveArticleNum(statistic.getAffiliation_ave_article_num());
        affiliationRadar.setMaxArticleNum(statistic.getAffiliation_max_article_num());
        affiliationRadar.setAveAuthorNum(statistic.getAffiliation_ave_author_num());
        affiliationRadar.setMaxAuthorNum(statistic.getAffiliation_max_author_num());

        return ResponseVO.buildSuccess(affiliationRadar);
    }
}
