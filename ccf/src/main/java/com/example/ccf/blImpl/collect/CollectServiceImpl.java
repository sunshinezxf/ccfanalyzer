package com.example.ccf.blImpl.collect;

import com.example.ccf.bl.collect.CollectService;
import com.example.ccf.data.collect.CollectMapper;
import com.example.ccf.data.search.SearchMapper;
import com.example.ccf.po.*;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.example.ccf.blImpl.JWT.JwtUtilsBIService;
import java.util.List;
import com.example.ccf.blImpl.Session.SessionBIService;
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private JwtUtilsBIService jwtUtilsBIService;
    @Autowired
    private SearchMapper searchMapper;
    @Autowired
    private SessionBIService sessionBIService;
    @Override
    public ResponseVO collect(String token, int paper_id){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
//        int user_id=sessionBIService.get_id(token);
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        int right=collectMapper.if_collect(user_id, paper_id);
        if(right>=1){
            return ResponseVO.buildSuccess("你已经收藏该文章。");
        }
        else {
            collectMapper.collect(user_id, paper_id);
            return ResponseVO.buildSuccess("收藏成功");
        }
    }
    @Override
    public ResponseVO cancel_collect(String token,int paper_id){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        int right=collectMapper.if_collect(user_id, paper_id);
        if(right==0){
            return ResponseVO.buildSuccess("你未收藏该文章。");
        }
        else {
            collectMapper.cancel_collect(user_id, paper_id);
            return ResponseVO.buildSuccess("取消收藏");
        }
    }
    @Override
    public ResponseVO collection_list(String token){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
//        int user_id=sessionBIService.get_id(token);
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        List<Integer> ids =collectMapper.collection_list(user_id);
        if(ids.size()==0){
            SearchResultNum r= new SearchResultNum();
            r.setTotalNum(0);
            return ResponseVO.buildSuccess(r);
        }
        List<SearchResultForm> srs=searchMapper.get_Inf(ids);
        for (int i = 0; i < ids.size(); i++) {
            SearchResultForm s=srs.get(i);
            List<Authors> authors=searchMapper.get_author(s.getPaperId());
            List<Affiliations> affiliations=searchMapper.get_affiliation(s.getPaperId());
            List<String> keywords=searchMapper.get_keyword(s.getPaperId());
//                    System.out.println(authors.get(0).getName());
            // System.out.println(affiliations.get(0).getName());
//                    System.out.println(keywords.get(0));
            s.setAuthors(authors);
            s.setAffiliations(affiliations);
            s.setKeywords(keywords);
            srs.set(i,s);
        }
        SearchResultNum r= new SearchResultNum();
        r.setTotalNum(ids.size());
        r.setPaperBriefInfoVOList(srs);
        return ResponseVO.buildSuccess(r);

    }
}
