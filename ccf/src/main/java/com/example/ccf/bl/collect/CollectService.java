package com.example.ccf.bl.collect;

import com.example.ccf.vo.ResponseVO;

public interface CollectService {
    ResponseVO collect(int user_id,int paper_id);
    ResponseVO cancel_collect(int user_id,int paper_id);
    ResponseVO collection_list(int user_id);
}
