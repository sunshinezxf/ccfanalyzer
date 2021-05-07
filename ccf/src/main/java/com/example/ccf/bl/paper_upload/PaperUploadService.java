package com.example.ccf.bl.paper_upload;

import com.example.ccf.vo.Private_paper;
import com.example.ccf.vo.ResponseVO;
import com.example.ccf.vo.TeamPaperImport;
import com.example.ccf.vo.UserPaperImport;

public interface PaperUploadService {
    ResponseVO team_paper_upload(TeamPaperImport t);

    ResponseVO private_paper_upload(UserPaperImport u);

    ResponseVO team_paper_alter(TeamPaperImport t);

    ResponseVO private_paper_alter(UserPaperImport u);
}
