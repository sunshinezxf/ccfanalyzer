package com.example.ccf.blImpl.share;

import com.example.ccf.bl.share.ShareService;
import com.example.ccf.blImpl.JWT.JwtUtilsBIService;
import com.example.ccf.data.share.ShareMapper;
import com.example.ccf.po.Private_Paper_Must;
import com.example.ccf.blImpl.Session.SessionBIService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    private JwtUtilsBIService jwtUtilsBIService;
    @Autowired
    private ShareMapper shareMapper;
    @Autowired
    private SessionBIService sessionBIService;
    @Override
    public ResponseVO Share_paper(int paper_id,String receiver_name,String token){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        int can_share=shareMapper.share_right(user_id, paper_id);
        if(can_share>=1){
            Integer receiver_id=shareMapper.find_id(receiver_name);
            if(receiver_id==null){
                return ResponseVO.buildSuccess("输入的用户名称错误");
            }
            else {
                int times=shareMapper.first_share(receiver_id,paper_id);
                if(times>=1)
                    return ResponseVO.buildSuccess("该文章已分享给该用户。");
                shareMapper.share_paper(receiver_id,paper_id);
                return ResponseVO.buildSuccess("分享成功");
            }
        }
        else{
            return ResponseVO.buildSuccess("你无权分享该文章");
        }

    }
    @Override
    public ResponseVO Receiver_list(String token){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        List<Private_Paper_Must> ps=shareMapper.receiver_list(user_id);
        int size=ps.size();
        if(size==0){
            return ResponseVO.buildSuccess(ps);
        }
        else{
            for(int i=0;i<size;i++) {
                Private_Paper_Must p=ps.get(i);
                p.setAuthors(shareMapper.authors_get(p.getPaper_id()));
                ps.set(i,p);
            }
            return ResponseVO.buildSuccess(ps);
        }

    }
}
