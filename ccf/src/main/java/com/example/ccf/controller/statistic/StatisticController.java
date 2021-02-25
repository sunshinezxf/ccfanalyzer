package com.example.ccf.controller.statistic;

import com.example.ccf.bl.StatisticService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
