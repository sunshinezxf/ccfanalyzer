package com.example.ccf.controller.statistic;

import com.example.ccf.bl.StatisticService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interests")
@CrossOrigin
public class StatisticController {

    private StatisticService statisticService;

    @Autowired
    public void DI(StatisticService statisticService){
        this.statisticService=statisticService;
    }

    @RequestMapping(value = "/statistics",method = RequestMethod.GET)
    public ResponseVO statistics(){
        return statisticService.getStatisticData();
    }

    @RequestMapping(value = "/crawl",method = RequestMethod.GET)
    public ResponseVO crawlStatistic(){
        return statisticService.getCrawlData();
    }

    @RequestMapping(value = "/getValue/author/{authorId}",method = RequestMethod.GET)
    public ResponseVO authorRadar(@PathVariable int authorId){
        return statisticService.getAuthorRadar(authorId);
    }

    @RequestMapping(value = "/getValue/affiliation/{affiliationId}",method = RequestMethod.GET)
    public ResponseVO affiliationRadar(@PathVariable int affiliationId){
        return statisticService.getAffiliationRadar(affiliationId);
    }
}
