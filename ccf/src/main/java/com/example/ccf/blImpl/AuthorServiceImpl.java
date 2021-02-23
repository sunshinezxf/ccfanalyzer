package com.example.ccf.blImpl;

import com.example.ccf.bl.AuthorService;
import com.example.ccf.data.author.AuthorMapper;
import com.example.ccf.data.paper.PaperMapper;
import com.example.ccf.po.Affiliation;
import com.example.ccf.po.Author;
import com.example.ccf.po.Paper;
import com.example.ccf.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorMapper authorMapper;
    private PaperMapper paperMapper;

    @Autowired
    public void DI(AuthorMapper authorMapper,PaperMapper paperMapper){
        this.authorMapper=authorMapper;
        this.paperMapper=paperMapper;
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
        List<RelatedPaper> paperBriefInfoVOList=new LinkedList<>();

        for(Paper paper:papers){

            RelatedPaper relatedPaper=new RelatedPaper();
            relatedPaper.setPaperId(paper.getPaper_id());
            relatedPaper.setTitle(paper.getTitle());
            relatedPaper.setCitationCnt(paper.getCitation());
            relatedPaper.setAbstract(paper.getAbstract());
            relatedPaper.setPublication(paper.getPublisher());
            relatedPaper.setCitationCnt(paper.getCitation());

            List<Author> poAuthors=paperMapper.getPaperAuthors(paper.getPaper_id());
            List<AuthorOmit> authors=new LinkedList<>();
            for(Author poAuthor:poAuthors){
                AuthorOmit authorOmit=new AuthorOmit();
                List<AffiliationOmit> affiliations=getAuthorAffiliation(poAuthor.getAuthor_id());

                authorOmit.setId(poAuthor.getAuthor_id());
                authorOmit.setName(poAuthor.getAuthor());
                authorOmit.setAffiliations(affiliations);

                authors.add(authorOmit);
            }

            relatedPaper.setAuthors(authors);
            relatedPaper.setKeywords(paperMapper.getPaperKeywords(paper.getPaper_id()));

            paperBriefInfoVOList.add(relatedPaper);
        }
        return ResponseVO.buildSuccess(paperBriefInfoVOList);
    }

    private List<AffiliationOmit> getAuthorAffiliation(int authorId) {
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
