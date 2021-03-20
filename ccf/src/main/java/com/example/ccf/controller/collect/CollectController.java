package com.example.ccf.controller.collect;
import com.example.ccf.bl.collect.CollectService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class CollectController {
    @Autowired
    private CollectService collectService;
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/collection",method = RequestMethod.GET)
    public ResponseVO collect(int user_id,int paper_id){
        return collectService.collect(user_id, paper_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/cancel/collection",method = RequestMethod.GET)
    public ResponseVO cancel_collect(int user_id,int paper_id){
        return collectService.cancel_collect(user_id, paper_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/collection/list",method = RequestMethod.GET)
    public ResponseVO collection_list(int user_id,int paper_id){
        return collectService.collection_list(user_id);
    }
}
