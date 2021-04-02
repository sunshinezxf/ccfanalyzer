package com.example.ccf.blImpl.share;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ShareServiceTest {
    @Autowired
    private ShareServiceImpl shareService;
//    @Test
//    public void share_success(){
//        //第一次成功，第二次就是已分享
//        System.out.println(shareService.Share_paper(1,"xiaohong",3).getContent());
//    }
    @Test
    public void share_fail(){
System.out.println();
    }
//    @Test
//    public void show_list(){
//        System.out.println(shareService.Receiver_list(4));
//    }
}
