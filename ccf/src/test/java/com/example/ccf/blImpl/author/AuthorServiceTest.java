package com.example.ccf.blImpl.author;

import com.example.ccf.data.ConnectTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthorServiceTest {

    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private AuthorBlService authorBlService;

    @Test
    public void getAuthorValue(){
        int value=authorBlService.getAuthorValue(1);
        logger.info(value+"");
    }

    @Test
    public void getAuthorName(){
        String name=authorBlService.getAuthorName(2);
        logger.info(name);
    }
}
