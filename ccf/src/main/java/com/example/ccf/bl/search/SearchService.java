package com.example.ccf.bl.search;

import com.example.ccf.po.AdvancedSearch;
import com.example.ccf.po.CommonSearch;

public interface SearchService {
    Object commonSearch(CommonSearch commonSearch);
    Object advancedSearch(AdvancedSearch advancedSearch);
}
