package com.example.ccf.bl;

import com.example.ccf.po.InfoPaper;
import com.example.ccf.po.Paper;

public interface PaperService {

    InfoPaper getInfoPaperById(int paper_id);

    Paper getPaperById(int paper_id);

}
