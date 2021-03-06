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
@RequestMapping("/paper")
public class PaperInfController {
    @Autowired
    private PaperInfService paperInfService;
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/simple/info",method = RequestMethod.GET)
    public ResponseVO paperSimpleInfo(int paperId){return paperInfService.getPaperInf(paperId);}
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/simple/info/ref",method = RequestMethod.GET)
    public ResponseVO paperSimpleInfoRef(RefForm refForm){return  paperInfService.getPaperRef(refForm); }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/matchAuthor",method = RequestMethod.GET)
    public ResponseVO paper_match_author(String input){return paperInfService.match_author(input);}
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/matchAffiliation",method = RequestMethod.GET)
    public ResponseVO paper_match_affiliation(String input){return paperInfService.match_affiliation(input);}
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/matchConference",method = RequestMethod.GET)
    public ResponseVO paper_match_conference(String input){return paperInfService.match_conference(input);}

}
