package com.example.ccf.data.statistic;

import com.example.ccf.data.ConnectTest;
import com.example.ccf.po.statistic.Crawl;
import com.example.ccf.po.statistic.Statistic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StatisticMapperTest {

    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private StatisticMapper statisticMapper;

    @Test
    public void getStatistic(){
        Statistic statistic=statisticMapper.getStatistic();
        logger.info(statistic.toString());
    }

    @Test
    public void getCrawlData(){
        List<Crawl> crawls=statisticMapper.getCrawlStatistic();
        logger.info(crawls.toString());
    }
}
