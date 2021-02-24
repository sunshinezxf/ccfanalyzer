package com.example.ccf.controller.segmentation;
import com.example.ccf.bl.segmentation.SegmentationService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/update/index")
public class SegmentationController {
    @Autowired
    private SegmentationService segmentationService;
    @RequestMapping(value ="/one",method = RequestMethod.GET)
    public ResponseVO updateMysqlOne(int paperId){return segmentationService.segmentation_title(paperId);}
    @RequestMapping(value ="/two",method = RequestMethod.GET)
    public ResponseVO updateMysqlTwo(int paperId){return segmentationService.segmentation_authorInf(paperId);}
    @RequestMapping(value ="/three",method = RequestMethod.GET)
    public ResponseVO updateMysqlThree(int paperId){return segmentationService.segmentation_keyword(paperId);}
}
