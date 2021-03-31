package com.example.ccf.blImpl.search;

import com.example.ccf.blImpl.search.SearchServiceImpl;
import com.example.ccf.po.AdvancedSearch;
import com.example.ccf.po.CommonSearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchServiceTest {
    @Autowired
    private SearchServiceImpl searchService;
    @Test
    public void test1(){
        CommonSearch c=new CommonSearch();
        c.setIndex(0);
        c.setSearchMessage("smart");
        searchService.commonSearch(c);
    }
    @Test
    public void test2(){
        AdvancedSearch a=new AdvancedSearch();
        List<String> authors=new ArrayList<>();
        List<String> affiliations=new ArrayList<>();
        List<String> keywords=new ArrayList<>();
//        authors.add("Muyang  Liu");
        //affiliations.add("University of Electronic Science and Technology of China， China");
        //keywords.add("test");
        a.setEndYear(0);
        a.setStartYear(0);
        a.setAuthors(authors);
        a.setAffiliations(affiliations);
        a.setKeywords(keywords);
        a.setIndex(0);
        a.setConferenceName("{ISSTA} '20: 29th {ACM} {SIGSOFT} International Symposium on Software Testing and Analysis, Virtual Event, USA, July 18-22, 2020");
        searchService.advancedSearch(a);
    }
}