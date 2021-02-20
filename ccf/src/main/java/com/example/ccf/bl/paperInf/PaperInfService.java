package com.example.ccf.bl.paperInf;

import com.example.ccf.po.RefForm;

public interface PaperInfService {
    Object getPaperInf(int paperId);
    Object getPaperRef(RefForm refForm);
}
