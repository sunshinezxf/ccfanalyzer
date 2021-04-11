package com.example.ccf.blImpl.author;

import com.example.ccf.bl.AuthorService;
import com.example.ccf.blImpl.conference.ConferenceBlService;
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
    private ConferenceBlService conferenceBlService;

    @Autowired
    public void DI(AuthorMapper authorMapper,PaperBlService paperBlService,ConferenceBlService conferenceBlService){
        this.authorMapper=authorMapper;
        this.paperBlService=paperBlService;
        this.conferenceBlService=conferenceBlService;
    }

    @Override
    public ResponseVO getAuthorPortrait(int authorId) {

        AuthorPortrait authorPortrait=new AuthorPortrait();

        Author author=authorMapper.getAuthorById(authorId);

        authorPortrait.setAuthorId(author.getAuthor_id());
        authorPortrait.setName(author.getAuthor());
        authorPortrait.setArticleNum(author.getArticle_num());
        authorPortrait.setArticleCitationNum(author.getArticle_citation_num());

        authorPortrait.setAffiliations(getAuthorAffiliation(authorId));

        List<String> meetings=authorMapper.getAuthorMainMeeting(authorId);
        authorPortrait.setConferences(conferenceBlService.getConferenceOmit(meetings));

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

    @Override
    public double getAuthorAveCitation(int authorId) {
        Author author=authorMapper.getAuthorById(authorId);
        return ((double) author.getArticle_citation_num())/((double) author.getArticle_num());
    }

    @Override
    public int getMaxAuthorCitation(int authorId) {

        return authorMapper.getMaxAuthorCitation(authorId);
    }

    @Override
    public List<Integer> getPaperNumGroupByYear(int authorId) {
        return authorMapper.getPaperNumGroupByYear(authorId);
    }

    @Override
    public int getAuthorValue(int authorId) {
        Author author=authorMapper.getAuthorById(authorId);
        double article_citation=Math.log(author.getArticle_citation_num());
        double article_num=Math.log(author.getArticle_num());

        return (int)(article_citation+article_num);
    }

    @Override
    public String getAuthorName(int authorId) {
        Author author=authorMapper.getAuthorById(authorId);
        return author.getAuthor();
    }
}
