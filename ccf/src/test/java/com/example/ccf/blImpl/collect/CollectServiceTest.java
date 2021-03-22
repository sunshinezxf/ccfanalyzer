package com.example.ccf.blImpl.collect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectServiceTest {
    @Autowired
    private CollectServiceImpl collectService;
//    @Test
//    public void collect(){
//        collectService.collect(2,1);
//    }
    @Test
    public void collection_list(){
       collectService.collection_list(2);
    }
//    @Test
//    public void cancel_collect(){
//        collectService.cancel_collect(2,1);
//    }
}
