package com.example.ccf.blImpl.statistic;

import com.example.ccf.bl.StatisticService;
import com.example.ccf.blImpl.Session.SessionBIService;
import com.example.ccf.blImpl.author.AuthorBlService;
import com.example.ccf.blImpl.relation.RelationBlService;
import com.example.ccf.data.statistic.StatisticMapper;
import com.example.ccf.po.Statistic;
import com.example.ccf.vo.AffiliationRadar;
import com.example.ccf.vo.AuthorRadar;
import com.example.ccf.vo.ResponseVO;
import com.example.ccf.vo.StatisticsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    private StatisticMapper statisticMapper;
    private RelationBlService relationBlService;
    private AuthorBlService authorBlService;

    @Autowired
    public void DI(StatisticMapper statisticMapper,SessionBIService sessionBIService,AuthorBlService authorBlService,RelationBlService relationBlService){
        this.statisticMapper=statisticMapper;
        this.authorBlService=authorBlService;
        this.relationBlService=relationBlService;
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
    public ResponseVO getAuthorRadar(int authorId) {


        Statistic statistic=statisticMapper.getStatistic();
        AuthorRadar authorRadar=new AuthorRadar();

        authorRadar.setAveCitationNum(statistic.getAuthor_ave_citation_num());
        authorRadar.setMaxCitationNum(statistic.getAuthor_max_citation_num());
        authorRadar.setAveArticleNum(statistic.getAuthor_ave_article_num());
        authorRadar.setMaxArticleNum(statistic.getAuthor_max_article_num());

        authorRadar.setAveAuthorCitation(authorBlService.getAuthorAveCitation(authorId));
        authorRadar.setMaxAuthorCitation(authorBlService.getMaxAuthorCitation(authorId));

        authorRadar.setAveRelation(relationBlService.getAveRelation(authorId));
        authorRadar.setMaxRelation(relationBlService.getMaxRelation(authorId));

        List<Integer> yearPaperNum=authorBlService.getPaperNumGroupByYear(authorId);
        int max=-1;
        double total=0;
        for(int i:yearPaperNum){
            max= Math.max(i, max);
            total=total+i;
        }

        authorRadar.setAveYearArticleNum(total/(double) yearPaperNum.size());
        authorRadar.setMaxYearArticleNum(max);

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
