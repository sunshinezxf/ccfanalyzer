package com.example.ccf.controller.collect;
import com.example.ccf.bl.collect.CollectService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class CollectController {
    @Autowired
    private CollectService collectService;
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/collection",method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO collect(String token,int paper_id){
        return collectService.collect(token, paper_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/delete",method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO cancel_collect(String token,int paper_id){
        return collectService.cancel_collect(token, paper_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/collection/list",method = RequestMethod.GET)
    public ResponseVO collection_list(String token){
        return collectService.collection_list(token);
    }
}
