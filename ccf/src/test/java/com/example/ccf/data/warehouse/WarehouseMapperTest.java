package com.example.ccf.data.warehouse;

import com.example.ccf.data.ConnectTest;
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
public class WarehouseMapperTest {
    private final static Logger logger= LoggerFactory.getLogger(ConnectTest.class);

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Test
    public void getTeamPrivatePaper(){

        List<Paper> papers= warehouseMapper.getTeamPrivatePaper(5);
        logger.info(papers.toString());
    }

    @Test
    public void getPrivatePaperAuthors(){

        List<String> authors=warehouseMapper.getPrivatePaperAuthors(10);
        logger.info(authors.toString());
    }

    @Test
    public void getPaperTeam(){

        logger.info(warehouseMapper.getPaperTeam(11)+"");
    }

    @Test
    public void getPaperOwner(){

        logger.info(warehouseMapper.getPaperOwner(10)+"");
    }
}
