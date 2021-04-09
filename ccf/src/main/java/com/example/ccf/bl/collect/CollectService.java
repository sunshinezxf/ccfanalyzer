package com.example.ccf.bl.collect;

import com.example.ccf.vo.ResponseVO;

public interface CollectService {
    ResponseVO collect(String token,int paper_id);
    ResponseVO cancel_collect(String token,int paper_id);
    ResponseVO collection_list(String token);
}
