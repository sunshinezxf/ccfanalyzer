package com.example.ccf.bl.paperInf;

import com.example.ccf.po.RefForm;
import com.example.ccf.vo.ResponseVO;

public interface PaperInfService {
    ResponseVO getPaperInf(int paperId);
    ResponseVO getPaperRef(RefForm refForm);
}
