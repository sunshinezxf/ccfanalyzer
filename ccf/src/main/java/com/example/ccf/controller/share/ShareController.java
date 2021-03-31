package com.example.ccf.controller.share;
import com.example.ccf.bl.share.ShareService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/user")
public class ShareController {
    @Autowired
    private ShareService shareService;
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/share",method = RequestMethod.POST)
    public ResponseVO user_share(int paper_id,String username,int user_id){
        return shareService.Share_paper(paper_id, username, user_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/receive/private_paper",method = RequestMethod.GET)
    public ResponseVO receive_private_paper(int user_id){
        return shareService.Receiver_list(user_id);
    }
}
