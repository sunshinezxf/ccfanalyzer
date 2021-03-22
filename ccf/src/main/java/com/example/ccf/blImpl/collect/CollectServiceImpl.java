package com.example.ccf.blImpl.collect;

import com.example.ccf.bl.collect.CollectService;
import com.example.ccf.data.collect.CollectMapper;
import com.example.ccf.data.search.SearchMapper;
import com.example.ccf.po.*;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private SearchMapper searchMapper;
    @Override
    public ResponseVO collect(int user_id, int paper_id){
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
    public ResponseVO cancel_collect(int user_id,int paper_id){
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
    public ResponseVO collection_list(int user_id){
        List<Integer> ids =collectMapper.collection_list(user_id);
        if(ids.size()==0){
            SearchResultNum r= new SearchResultNum();
            r.setTotalNum(0);
            return ResponseVO.buildSuccess(r);
        }
        List<SearchResultForm> srs=searchMapper.get_Inf(ids);
        for (int i = 0; i < ids.size(); i++) {
            SearchResultForm s=srs.get(i);
            System.out.println(s.getPaperId());
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
