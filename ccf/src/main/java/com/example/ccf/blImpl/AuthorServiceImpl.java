package com.example.ccf.blImpl;

import com.example.ccf.bl.AuthorService;
import com.example.ccf.data.author.AuthorMapper;
import com.example.ccf.data.paper.PaperMapper;
import com.example.ccf.po.Affiliation;
import com.example.ccf.po.Author;
import com.example.ccf.vo.AffiliationOmit;
import com.example.ccf.vo.AuthorPortrait;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorMapper authorMapper;

    @Autowired
    public void DI(AuthorMapper authorMapper){
        this.authorMapper=authorMapper;
    }

    @Override
    public ResponseVO getAuthorPortrait(int authorId) {

        AuthorPortrait authorPortrait=new AuthorPortrait();

        Author author=authorMapper.getAuthorById(authorId);

        authorPortrait.setAuthorId(author.getAuthor_id());
        authorPortrait.setName(author.getAuthor());
        authorPortrait.setArticleNum(author.getArticle_num());
        authorPortrait.setArticleCitationNum(author.getArticle_citation_num());

        List<Affiliation> affiliations=authorMapper.getAuthorAffiliation(authorId);
        List<AffiliationOmit> affiliationOmits=new LinkedList<>();
        for(Affiliation affiliation:affiliations){

            AffiliationOmit affiliationOmit=new AffiliationOmit();
            affiliationOmit.setId(affiliation.getAffiliation_id());
            affiliationOmit.setName(affiliation.getAffiliation());
            affiliationOmits.add(affiliationOmit);
        }

        authorPortrait.setAffiliationOmits(affiliationOmits);

        //TODO 主要参与会议的列表

        return ResponseVO.buildSuccess(authorPortrait);
    }

    @Override
    public ResponseVO getAuthorRelatedPapers(int authorId,int index) {
        return null;
    }
}
