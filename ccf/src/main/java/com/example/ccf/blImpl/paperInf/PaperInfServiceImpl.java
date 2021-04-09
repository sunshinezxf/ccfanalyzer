package com.example.ccf.blImpl.paperInf;

import com.example.ccf.bl.paperInf.PaperInfService;
import com.example.ccf.data.paperInf.PaperInfMapper;
import com.example.ccf.data.search.SearchMapper;
import com.example.ccf.po.*;
import com.example.ccf.vo.Private_paper;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PaperInfServiceImpl implements PaperInfService {
    @Autowired
    private PaperInfMapper paperInfMapper;
    @Autowired
    private SearchMapper searchMapper;
    @Override
    public ResponseVO getPaperInf(int paperId){
        PaperInfOne p=paperInfMapper.get_Inf(paperId);
        PaperInfTwo p2=new PaperInfTwo();
        int ref=paperInfMapper.get_Ref_Num(paperId);
        List<Authors> authors=searchMapper.get_author(paperId);
        List<Affiliations> affiliations=searchMapper.get_affiliation(paperId);
        List<String> keywords=searchMapper.get_keyword(paperId);
        String[] pages=p.getPages().split("--");
        int startPage=Integer.parseInt(pages[0]);
        int endPage=Integer.parseInt(pages[1]);
        p2.setPaperId(paperId);
        p2.setAuthors(authors);
        p2.setAffiliations(affiliations);
        p2.setPublication(p.getPublication());
        p2.setPublicationYear(p.getPublicationYear());
        p2.setStartPage(startPage);
        p2.setEndPage(endPage);
        p2.setSummary(p.getSummary());
        p2.setDoi(p.getDoi());
        p2.setUrl(p.getUrl());
        p2.setArticleCitationCount(ref);
        p2.setKeywords(keywords);
        p2.setTitle(p.getTitle());
        return ResponseVO.buildSuccess(p2);

    }
    @Override
    public ResponseVO getPaperRef(RefForm refForm){
        int index=refForm.getIndex();
        int paperId=refForm.getPaperId();
        String ref_content=paperInfMapper.get_Ref(paperId);
        String[] ref=ref_content.split("\\^\\^\\^");
        int num=paperInfMapper.get_Ref_Num(paperId);
        List<References> references=new ArrayList<>();
        for(int i=0;i<ref.length;i++){
            References r=new References();
            String[] sr=ref[i].split("\\*\\*\\*",2);
            r.setReference(sr[0]);
            r.setGoogleScholarLink(sr[1]);
//            System.out.println(sr[0]);
//            System.out.println(sr[1]);
            references.add(r);
        }
        RefResult refResult=new RefResult();
        refResult.setReferenceCount(num);
        refResult.setReferences(references);
        return ResponseVO.buildSuccess(refResult);
    }
    @Override
    public ResponseVO match_author(String input){
        List<Authors> r=paperInfMapper.match_author(input);
//        for(int i=0;i<r.size();i++){
//            System.out.println(r.get(i).getName());
//        }
        return ResponseVO.buildSuccess(r);
    }
    @Override
    public ResponseVO match_affiliation(String input){
       // System.out.println(input);
        String l=input.toLowerCase();
        for(int i=0;i<l.length();i++){
          if(!(l.charAt(i) >= 'a' && l.charAt(i) <= 'z')){
              if(l.charAt(i)!=' '){
                  input=input.substring(0,i)+","+input.substring(i+1,l.length());
                  break;
              }
          }
         }
       // System.out.println(input);
        List<Affiliations> r=paperInfMapper.match_affiliation(input);
        for(int i=0;i<r.size();i++){
            System.out.println(r.get(i).getName());
        }
        return ResponseVO.buildSuccess(r);
    }
    @Override
    public ResponseVO match_conference(String input){
        List<String> r=paperInfMapper.match_conference(input);
//        for(int i=0;i<r.size();i++){
//            System.out.println(r.get(i));
//        }
        return ResponseVO.buildSuccess(r);
    }
    @Override
    public ResponseVO get_private_paper_inf(int paperId,int user_id){
        int right=paperInfMapper.get_private_paper_right(paperId,user_id);
        if(right>=1){
            Private_paper private_paper=paperInfMapper.get_private_paper_inf(paperId);
            private_paper.setAuthors(paperInfMapper.get_private_paper_authors(paperId));
            //System.out.println(private_paper.getBook_title());
            return ResponseVO.buildSuccess(private_paper);
        }
        else{
            return ResponseVO.buildSuccess("你没有权限访问该文章");
        }

    }
}
