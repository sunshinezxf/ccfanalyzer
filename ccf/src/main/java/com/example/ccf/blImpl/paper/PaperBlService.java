package com.example.ccf.blImpl.paper;

import com.example.ccf.po.Paper;
import com.example.ccf.vo.RelatedPaper;

import java.util.List;

public interface PaperBlService {

    List<RelatedPaper> getRelatedPaper(List<Paper> papers);
}
