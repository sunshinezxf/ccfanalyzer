package com.example.ccf.data.affiliation;

import com.example.ccf.data.ConnectTest;
import com.example.ccf.po.Affiliation;
import com.example.ccf.po.Author;
import com.example.ccf.po.Paper;
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
public class AffiliationMapperTest {

    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private AffiliationMapper affiliationMapper;

    @Test
    public void affiliationTest(){

        Affiliation affiliation=affiliationMapper.getAffiliationById(1);
        logger.info(affiliation.toString());
    }

    @Test
    public void getAffiliationPapers(){

        List<Paper> papers=affiliationMapper.getAffiliationPapers(1,0);
        logger.info(papers.toString());
    }

    @Test
    public void getAffiliationAuthors(){

        List<Author> authors=affiliationMapper.getAffiliationAuthors(1,0);
        logger.info(authors.toString());
    }

    @Test
    public void getAffiliationMainMeeting(){

        List<String> strings=affiliationMapper.getAffiliationMainMeeting(1);
        logger.info(strings.toString());
    }
}
