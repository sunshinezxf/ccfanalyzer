package com.example.ccf.controller.search;
import com.example.ccf.bl.search.SearchService;
import com.example.ccf.po.AdvancedSearch;
import com.example.ccf.po.CommonSearch;
import com.example.ccf.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/paper/search")
public class SearchController {
    @Autowired
    private SearchService searchService;
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/common",method = RequestMethod.GET)
    public ResponseVO commonSearch(CommonSearch commonSearch){return searchService.commonSearch(commonSearch);}
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/advanced",method = RequestMethod.GET)
    public ResponseVO advancedSearch(AdvancedSearch advancedSearch){return  searchService.advancedSearch(advancedSearch);}
}
