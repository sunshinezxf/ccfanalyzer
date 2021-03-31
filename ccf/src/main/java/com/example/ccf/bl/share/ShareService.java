package com.example.ccf.bl.share;

import com.example.ccf.vo.ResponseVO;

public interface ShareService {
    ResponseVO Share_paper(int paper_id,String receiver_name,int user_id);
    //查看被分享的论文列表,可以查看被分享的论文
    ResponseVO Receiver_list(int user_id);
}
