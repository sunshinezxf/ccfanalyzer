package com.example.ccf.blImpl.affiliation;

import com.example.ccf.bl.AffiliationService;
import com.example.ccf.blImpl.author.AuthorBlService;
import com.example.ccf.blImpl.paper.PaperBlService;
import com.example.ccf.data.affiliation.AffiliationMapper;
import com.example.ccf.po.Affiliation;
import com.example.ccf.po.Author;
import com.example.ccf.po.Paper;
import com.example.ccf.vo.AffiliationPortrait;
import com.example.ccf.vo.AuthorOmit;
import com.example.ccf.vo.RelatedPaper;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AffiliationServiceImpl implements AffiliationService {

    private AffiliationMapper affiliationMapper;
    private PaperBlService paperBlService;

    @Autowired
    public void DI(AffiliationMapper affiliationMapper, PaperBlService paperBlService){
        this.affiliationMapper=affiliationMapper;
        this.paperBlService=paperBlService;
    }

    @Override
    public ResponseVO getAffiliationPortrait(int affiliationId) {

        AffiliationPortrait affiliationPortrait=new AffiliationPortrait();

        Affiliation affiliation=affiliationMapper.getAffiliationById(affiliationId);

        affiliationPortrait.setAffiliationId(affiliation.getAffiliation_id());
        affiliationPortrait.setName(affiliation.getAffiliation());
        affiliationPortrait.setArticleNum(affiliation.getAuthor_num());
        affiliationPortrait.setArticleCitationNum(affiliation.getArticle_citation_num());
        affiliationPortrait.setAuthorNum(affiliation.getAuthor_num());

        //TODO 主要参与会议的列表

        return ResponseVO.buildSuccess(affiliationPortrait);
    }

    @Override
    public ResponseVO getAffiliationRelatedPapers(int affiliationId,int index) {

        List<Paper> papers=affiliationMapper.getAffiliationPapers(affiliationId,index*10);
        List<RelatedPaper> paperBriefInfoVOList=paperBlService.getRelatedPaper(papers);

        return ResponseVO.buildSuccess(paperBriefInfoVOList);
    }

    @Override
    public ResponseVO getAffiliationAuthors(int affiliationId, int index) {
        List<AuthorOmit> authors=new LinkedList<>();
        List<Author> poAuthors=affiliationMapper.getAffiliationAuthors(affiliationId,index*10);

        for(Author poAuthor:poAuthors){
            AuthorOmit authorOmit=new AuthorOmit();
            authorOmit.setId(poAuthor.getAuthor_id());
            authorOmit.setName(poAuthor.getAuthor());
            // authorOmit的affiliations未设置，前端应该不影响

            authors.add(authorOmit);
        }

        return ResponseVO.buildSuccess(authors);
    }
}
