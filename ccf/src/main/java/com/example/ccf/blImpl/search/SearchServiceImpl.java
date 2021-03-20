package com.example.ccf.blImpl.search;

import com.example.ccf.bl.search.SearchService;
import com.example.ccf.data.search.SearchMapper;
import com.example.ccf.po.*;

import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private SearchMapper searchMapper;
    @Override
    public ResponseVO commonSearch(CommonSearch commonSearch) {
        int index = commonSearch.getIndex();
        String message = commonSearch.getSearchMessage();
        String[] ms = message.toLowerCase().split(" ");
        int size = ms.length;
        if (size >= 1) {
            List<Integer> ids = searchMapper.get_id(ms[0]);
            for (int i = 1; i < size; i++) {
                ids.retainAll(searchMapper.get_id(ms[i]));
            }
            int result_n=ids.size();
            if(result_n>=1&&result_n>=10*index) {
//                System.out.println(result_n);
                List<SearchResultForm> srs=searchMapper.get_Inf(ids);
                if(result_n>=10*index+10)
                    result_n=10*index+10;
                for (int i = 10*index; i < result_n; i++) {
                    SearchResultForm s=srs.get(i);
                    System.out.println(s.getPaperId());
                    List<Authors> authors=searchMapper.get_author(s.getPaperId());
                    List<Affiliations> affiliations=searchMapper.get_affiliation(s.getPaperId());
                    List<String> keywords=searchMapper.get_keyword(s.getPaperId());
//                    System.out.println(authors.get(0).getName());
                   // System.out.println(affiliations.get(0).getName());
//                    System.out.println(keywords.get(0));
                    s.setAuthors(authors);
                    s.setAffiliations(affiliations);
                    s.setKeywords(keywords);
                    srs.set(i,s);
                }
                SearchResultNum r= new SearchResultNum();
                r.setTotalNum(ids.size());
                r.setPaperBriefInfoVOList(srs);
                return ResponseVO.buildSuccess(r);
            }
            else{
                return  ResponseVO.buildSuccess("查询结果为0");
            }

        }
        else
        return ResponseVO.buildSuccess("没有输入的查询");
    }
    @Override
    public ResponseVO advancedSearch(AdvancedSearch advancedSearch){
        List<String> authors=advancedSearch.getAuthors();
        List<String> affiliations=advancedSearch.getAffiliations();
        List<String> keywords=advancedSearch.getKeywords();
        int startYear=advancedSearch.getStartYear();
        int endYear=advancedSearch.getEndYear();
        int index=advancedSearch.getIndex();
        String conference=advancedSearch.getConferenceName();
        boolean author_search= false;
        boolean affiliation_search= false;
        boolean keywords_search= false;
        boolean year_search= false;
        boolean conference_search= false;
        List<Integer> ids_one=new ArrayList<>();
        List<Integer> ids_two=new ArrayList<>();
        List<Integer> ids_three=new ArrayList<>();
        List<Integer> ids_four=new ArrayList<>();
        List<Integer> ids_five=new ArrayList<>();
        List<Integer> ids=new ArrayList<>();
        int size=authors.size();
        if(size>=1) {
            author_search = true;
            ids_one =searchMapper.author_to_id(authors.get(0));
            for (int i = 1; i < size; i++) {
                ids_one.retainAll(searchMapper.author_to_id(authors.get(i)));
            }
        }
        size=affiliations.size();
        if(size>=1){
            affiliation_search=true;
            ids_two=searchMapper.affiliation_to_id(affiliations.get(0).replace("，",","));
            for (int i = 1; i < size; i++) {
                ids_two.retainAll(searchMapper.affiliation_to_id(change_str(affiliations.get(i).replace("，",","))));
            }
        }
        size=keywords.size();
        if(size>=1){
            keywords_search=true;
            ids_three=searchMapper.keyword_to_id(keywords.get(0).toLowerCase());
            for (int i = 1; i < size; i++){
                ids_three.retainAll(searchMapper.keyword_to_id(keywords.get(i).toLowerCase()));
            }
        }
        if(startYear!=0&&endYear!=0){
            year_search=true;
            List<String> y=new ArrayList<>();
            if(startYear==endYear){
                y.add(startYear+"");
                ids_four=searchMapper.year_to_id(y);
            }
            else{
                int d =endYear-startYear;
                for(int j=0;j<=d;j++){
                    int dd = startYear+j;
                    y.add(dd+"");
                }
                ids_four=searchMapper.year_to_id(y);
            }
        }
        if(conference.length()>0){
            conference_search=true;
            ids_five=searchMapper.conference_to_id(conference);
        }
        if(author_search)
            ids=ids_one;
        else if(affiliation_search)
            ids=ids_two;
        else if(keywords_search)
            ids=ids_three;
        else if(year_search)
            ids=ids_four;
        else if(conference_search)
            ids=ids_five;
        if(ids.size()==0){
            return ResponseVO.buildSuccess("搜索结果为0");
        }
        else{
            if(author_search)
                ids.retainAll(ids_one);
            if(affiliation_search)
                ids.retainAll(ids_two);
            if(keywords_search)
                ids.retainAll(ids_three);
            if(year_search)
                ids.retainAll(ids_four);
            if(conference_search)
                ids.retainAll(ids_five);
        }
        if(ids.size()==0){
            return ResponseVO.buildSuccess("搜索结果为0");
        }
        int result_n=ids.size();
        if(result_n>=1&&result_n>=10*index) {
//            System.out.println(result_n);
            List<SearchResultForm> srs=searchMapper.get_Inf(ids);
            List<SearchResultForm> srs_new=new ArrayList<>();
            if(result_n>=10*index+10)
                result_n=10*index+10;
            for (int i = 10*index; i < result_n; i++) {
                SearchResultForm s=srs.get(i);
                List<Authors> r_authors=searchMapper.get_author(s.getPaperId());
                List<Affiliations> r_affiliations=searchMapper.get_affiliation(s.getPaperId());
                List<String> r_keywords=searchMapper.get_keyword(s.getPaperId());
//                System.out.println(r_authors.get(0).getName());
//                System.out.println(s.getPaperId());
//                System.out.println(r_affiliations.get(0).getName());
//                System.out.println(r_keywords.get(0));
                s.setAuthors(r_authors);
                s.setAffiliations(r_affiliations);
                s.setKeywords(r_keywords);
                srs.set(i,s);
                srs_new.add(srs.get(i));
            }
            SearchResultNum r= new SearchResultNum();
            r.setTotalNum(ids.size());
            r.setPaperBriefInfoVOList(srs_new);
            return ResponseVO.buildSuccess(r);
        }
        else
            return ResponseVO.buildSuccess("搜索结果为0");
    }
    public String change_str(String input){
        String l=input.toLowerCase();
        for(int i=0;i<l.length();i++){
            if(!(l.charAt(i) >= 'a' && l.charAt(i) <= 'z')){
                if(l.charAt(i)!=' '){
                    input=input.substring(0,i)+","+input.substring(i+1,l.length());
                    break;
                }
            }
        }
        return input;

    }
}
