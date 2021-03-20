package com.example.ccf.blImpl.paperInf;
import com.example.ccf.blImpl.paperInf.PaperInfServiceImpl;
import com.example.ccf.po.RefForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaperInfServiceTest {
    @Autowired
    private PaperInfServiceImpl paperInfService;
    @Test
    public void test1(){
        paperInfService.getPaperInf(1);
    }
    @Test
    public void test2(){
        RefForm r= new RefForm();
        r.setIndex(0);
        r.setPaperId(1);
        paperInfService.getPaperRef(r);
    }
    @Test
    public void test3(){
        //paperInfService.match_author("Yang");
         paperInfService.match_affiliation("Nanjing University, China");
        //paperInfService.match_conference("{ISSTA} '20: 29th {ACM} {SIGSOFT} International Symposium on Software");
    }
    @Test
    //查看私人文章
    public void test4(){
        System.out.println(paperInfService.get_private_paper_inf(1,2).getContent());
        System.out.println(paperInfService.get_private_paper_inf(1,3).getContent());
    }
}
