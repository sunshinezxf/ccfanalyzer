package com.example.ccf.blImpl.collect;

import com.example.ccf.bl.collect.CollectService;
import com.example.ccf.data.collect.CollectMapper;
import com.example.ccf.po.PaperID;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectMapper collectMapper;
    @Override
    public ResponseVO collect(int user_id, int paper_id){
        collectMapper.collect(user_id,paper_id);
        return  ResponseVO.buildSuccess("收藏成功");
    }
    @Override
    public ResponseVO cancel_collect(int user_id,int paper_id){
        collectMapper.cancel_collect(user_id, paper_id);
        return ResponseVO.buildSuccess("取消收藏");
    }
    @Override
    public ResponseVO collection_list(int user_id){
        List<PaperID> ps=collectMapper.collection_list(user_id);
        //System.out.println(ps.get(0).getTitle());
        return ResponseVO.buildSuccess(ps);
    }
}
