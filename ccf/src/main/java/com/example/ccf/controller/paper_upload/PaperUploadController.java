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
    public ResponseVO user_upload(UserPaperImport u){
        return paperUploadService.private_paper_upload(u);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/team/paperImport",method = RequestMethod.POST)
    public ResponseVO team_upload(TeamPaperImport t){
        return paperUploadService.team_paper_upload(t);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/user/paperAlter",method = RequestMethod.POST)
    public ResponseVO user_alter(UserPaperImport u){
        return paperUploadService.private_paper_alter(u);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/team/paperAlter",method = RequestMethod.POST)
    public ResponseVO team_alter(TeamPaperImport t){
        return paperUploadService.team_paper_alter(t);
    }
}
