package com.example.ccf.data.author;

import com.example.ccf.bl.AuthorService;
import com.example.ccf.data.ConnectTest;
import com.example.ccf.po.Affiliation;
import com.example.ccf.po.Author;
import com.example.ccf.po.Paper;
import com.example.ccf.vo.ResponseVO;
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
    @Autowired
    private AuthorService authorService;

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

    @Test
    public void authorPaper(){
        List<Paper> papers=authorMapper.getAuthorPapers(1,0);
        logger.info(papers.toString());
    }

    @Test
    public void getAuthorRelatedPapers(){
        ResponseVO responseVO=authorService.getAuthorRelatedPapers(1,0);
        logger.info(responseVO.getContent().toString());
    }

    @Test
    public void getAuthorMainMeeting(){

        List<String> meetings=authorMapper.getAuthorMainMeeting(1);
        logger.info(meetings.toString());
    }

    @Test
    public void getPaperNumGroupByYear(){
        List<Integer> paperNum=authorMapper.getPaperNumGroupByYear(1);
        logger.info(paperNum.toString());
        paperNum=authorMapper.getPaperNumGroupByYear(8);
        logger.info(paperNum.toString());

    }
}
