package com.example.ccf.bl.paper_upload;

import com.example.ccf.vo.Private_paper;
import com.example.ccf.vo.ResponseVO;

public interface PaperUploadService {
    ResponseVO team_paper_upload(Private_paper private_paper, int team_id);

    ResponseVO private_paper_upload(Private_paper private_paper,int user_id);
}
