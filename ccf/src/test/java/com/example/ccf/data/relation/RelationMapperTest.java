package com.example.ccf.data.relation;

import com.example.ccf.data.ConnectTest;
import com.example.ccf.data.statistic.StatisticMapper;
import com.example.ccf.po.AuthorRelation;
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
public class RelationMapperTest {
    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private RelationMapper relationMapper;

    @Test
    public void getRelations(){
        List<AuthorRelation> relations=relationMapper.getRelations(1);
        logger.info(relations.toString());
    }

    @Test
    public void getMaxRelation(){
        logger.info(relationMapper.getMaxCoopRelation(1)+"");

    }
}
