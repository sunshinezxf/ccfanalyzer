package com.example.ccf.controller;

import com.example.ccf.controller.relation.RelationController;
import com.example.ccf.data.ConnectTest;
import com.example.ccf.vo.ResponseVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RelationControllerTest {
    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private RelationController relationController;

    @Test
    public void relation(){
        ResponseVO responseVO = relationController.authorRelation(1);

        logger.info(responseVO.getContent().toString());
    }

}
