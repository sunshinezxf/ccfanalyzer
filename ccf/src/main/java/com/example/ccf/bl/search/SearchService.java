package com.example.ccf.bl.search;

import com.example.ccf.po.AdvancedSearch;
import com.example.ccf.po.CommonSearch;
import com.example.ccf.vo.ResponseVO;

public interface SearchService {
    ResponseVO commonSearch(CommonSearch commonSearch);
    ResponseVO advancedSearch(AdvancedSearch advancedSearch);
}
