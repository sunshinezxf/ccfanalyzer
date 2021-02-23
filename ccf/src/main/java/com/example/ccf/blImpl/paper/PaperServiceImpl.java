package com.example.ccf.blImpl.paper;

import com.example.ccf.bl.PaperService;
import com.example.ccf.blImpl.author.AuthorBlService;
import com.example.ccf.data.paper.PaperMapper;
import com.example.ccf.po.Author;
import com.example.ccf.po.Paper;
import com.example.ccf.vo.AffiliationOmit;
import com.example.ccf.vo.AuthorOmit;
import com.example.ccf.vo.RelatedPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService,PaperBlService {

    private PaperMapper paperMapper;
    private AuthorBlService authorBlService;

    @Autowired
    public void DI(PaperMapper paperMapper,AuthorBlService authorBlService){
        this.paperMapper=paperMapper;
        this.authorBlService=authorBlService;
    }

    public Paper getPaperById(int paper_id){
        return paperMapper.getPaperById(paper_id);
    }

    @Override
    public List<RelatedPaper> getRelatedPaper(List<Paper> papers) {

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
                List<AffiliationOmit> affiliations=authorBlService.getAuthorAffiliation(poAuthor.getAuthor_id());

                authorOmit.setId(poAuthor.getAuthor_id());
                authorOmit.setName(poAuthor.getAuthor());
                authorOmit.setAffiliations(affiliations);

                authors.add(authorOmit);
            }

            relatedPaper.setAuthors(authors);
            relatedPaper.setKeywords(paperMapper.getPaperKeywords(paper.getPaper_id()));

            paperBriefInfoVOList.add(relatedPaper);
        }
        return paperBriefInfoVOList;
    }
}
