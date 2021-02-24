package com.example.ccf.data;

import com.example.ccf.bl.PaperService;
import com.example.ccf.po.Paper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ConnectTest {
    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private PaperService paperService;

    @Test
    public void paperTest(){

        Paper paper=paperService.getPaperById(1);
        logger.info(paper.toString());

    }

}
