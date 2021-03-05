package com.example.ccf.controller.paperInf;
import com.example.ccf.bl.paperInf.PaperInfService;

import com.example.ccf.po.RefForm;
import com.example.ccf.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/paper/simple")
public class PaperInfController {
    @Autowired
    private PaperInfService paperInfService;
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/info",method = RequestMethod.GET)
    public ResponseVO paperSimpleInfo(int paperId){return paperInfService.getPaperInf(paperId);}
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/info/ref",method = RequestMethod.GET)
    public ResponseVO paperSimpleInfoRef(RefForm refForm){return  paperInfService.getPaperRef(refForm);}
}
