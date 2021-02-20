package com.example.ccf.data.affiliation;

import com.example.ccf.data.ConnectTest;
import com.example.ccf.po.Affiliation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AffiliationMapperTest {

    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private AffiliationMapper affiliationMapper;

    @Test
    public void affiliationTest(){
        Affiliation affiliation=affiliationMapper.getAffiliationById(1);
        logger.info(affiliation.toString());
    }
}
