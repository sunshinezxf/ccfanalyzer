package com.example.ccf.data.author;

import com.example.ccf.bl.AuthorService;
import com.example.ccf.data.ConnectTest;
import com.example.ccf.po.Affiliation;
import com.example.ccf.po.Author;
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
public class AuthorMapperTest {

    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private AuthorMapper authorMapper;

    @Test
    public void authorAffiliationsTest(){

        List<Affiliation> affiliations=authorMapper.getAuthorAffiliation(38);
        logger.info(affiliations.toString());
    }

    @Test
    public void authorTest(){

        Author author =authorMapper.getAuthorById(1);
        logger.info(author.toString());
    }
}
