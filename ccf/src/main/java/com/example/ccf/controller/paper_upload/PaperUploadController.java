package com.example.ccf.controller.paper_upload;
import com.example.ccf.bl.paper_upload.PaperUploadService;
import com.example.ccf.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class PaperUploadController {
    @Autowired
    private PaperUploadService paperUploadService;
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/user/paperImport",method = RequestMethod.POST)
    public ResponseVO user_upload(Private_paper p,int user_id){
        return paperUploadService.private_paper_upload(p,user_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/team/paperImport",method = RequestMethod.POST)
    public ResponseVO team_upload(Private_paper p,int team_id){
        return paperUploadService.private_paper_upload(p,team_id);
    }
}