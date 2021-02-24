package com.example.ccf.blImpl.author;

import com.example.ccf.bl.AuthorService;
import com.example.ccf.blImpl.paper.PaperBlService;
import com.example.ccf.data.author.AuthorMapper;
import com.example.ccf.po.Affiliation;
import com.example.ccf.po.Author;
import com.example.ccf.po.Paper;
import com.example.ccf.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService,AuthorBlService {

    private AuthorMapper authorMapper;
    private PaperBlService paperBlService;

    @Autowired
    public void DI(AuthorMapper authorMapper,PaperBlService paperBlService){
        this.authorMapper=authorMapper;
        this.paperBlService=paperBlService;
    }

    @Override
    public ResponseVO getAuthorPortrait(int authorId) {

        AuthorPortrait authorPortrait=new AuthorPortrait();

        Author author=authorMapper.getAuthorById(authorId);

        authorPortrait.setAuthorId(author.getAuthor_id());
        authorPortrait.setName(author.getAuthor());
        authorPortrait.setArticleNum(author.getArticle_num());
        authorPortrait.setArticleCitationNum(author.getArticle_citation_num());

        authorPortrait.setAffiliationOmits(getAuthorAffiliation(authorId));

        //TODO 主要参与会议的列表

        return ResponseVO.buildSuccess(authorPortrait);
    }

    @Override
    public ResponseVO getAuthorRelatedPapers(int authorId,int index) {
        List<Paper> papers=authorMapper.getAuthorPapers(authorId,index*10);
        List<RelatedPaper> paperBriefInfoVOList=paperBlService.getRelatedPaper(papers);

        return ResponseVO.buildSuccess(paperBriefInfoVOList);
    }

    public List<AffiliationOmit> getAuthorAffiliation(int authorId) {
        List<Affiliation> affiliations=authorMapper.getAuthorAffiliation(authorId);
        List<AffiliationOmit> affiliationOmits=new LinkedList<>();
        for(Affiliation affiliation:affiliations){

            AffiliationOmit affiliationOmit=new AffiliationOmit();
            affiliationOmit.setId(affiliation.getAffiliation_id());
            affiliationOmit.setName(affiliation.getAffiliation());
            affiliationOmits.add(affiliationOmit);
        }

        return affiliationOmits;
    }
}
