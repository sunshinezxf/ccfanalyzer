package com.example.ccf.blImpl.segmentation;
import com.example.ccf.po.AdvancedSearch;
import com.example.ccf.po.CommonSearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SegmentationServiceTest {
    @Autowired
    private SegmentationServiceImpl segmentationService;
    @Test
    public  void test1(){
        //segmentationService.segmentation_keyword(1);
    }
}
