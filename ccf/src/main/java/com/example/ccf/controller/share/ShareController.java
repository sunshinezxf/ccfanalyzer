package com.example.ccf.controller.share;
import com.example.ccf.bl.share.ShareService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class ShareController {
    @Autowired
    private ShareService shareService;
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/share",method = RequestMethod.POST)
    @ResponseBody
    public ResponseVO user_share(int paper_id,String username,String token){
        return shareService.Share_paper(paper_id, username, token);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/receive/private_paper",method = RequestMethod.GET)
    public ResponseVO receive_private_paper(String token){
        return shareService.Receiver_list(token);
    }
}
