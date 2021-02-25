package com.example.ccf.controller.portrait;

import com.example.ccf.bl.AffiliationService;
import com.example.ccf.bl.AuthorService;
import com.example.ccf.bl.ConferenceService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/portrait")
@CrossOrigin
public class PortraitController {

    private AffiliationService affiliationService;
    private AuthorService authorService;
    private ConferenceService conferenceService;

    @Autowired
    public void DI(AffiliationService affiliationService,AuthorService authorService,ConferenceService conferenceService){
        this.affiliationService=affiliationService;
        this.authorService=authorService;
        this.conferenceService=conferenceService;
    }

    @RequestMapping(value = "/author/{authorId}",method = RequestMethod.GET)
    public ResponseVO authorPortrait(@PathVariable int authorId){
        return authorService.getAuthorPortrait(authorId);
    }

    @RequestMapping(value = "/affiliation/{affiliationId}",method = RequestMethod.GET)
    public ResponseVO affiliationPortrait(@PathVariable int affiliationId){
        return affiliationService.getAffiliationPortrait(affiliationId);
    }

    @RequestMapping(value = "/conference/{conferenceId}",method = RequestMethod.GET)
    public ResponseVO conferencePortrait(@PathVariable int conferenceId){
        return conferenceService.getConferencePortrait(conferenceId);
    }

    @RequestMapping(value = "/author/papers",method = RequestMethod.GET)
    public ResponseVO authorRelatedPapers(int authorId,int index){
        return authorService.getAuthorRelatedPapers(authorId,index);
    }

    @RequestMapping(value = "/conference/papers",method = RequestMethod.GET)
    public ResponseVO conferenceRelatedPapers(int conferenceId,int index){
        return conferenceService.getConferenceRelatedPapers(conferenceId,index);
    }

    @RequestMapping(value = "/affiliation/papers",method = RequestMethod.GET)
    public ResponseVO affiliationRelatedPapers(int affiliationId,int index){
        return affiliationService.getAffiliationRelatedPapers(affiliationId,index);
    }

    // 作者按照引用总数降序排列
    @RequestMapping(value = "/affiliation/authors",method = RequestMethod.GET)
    public ResponseVO affiliationAuthors(int affiliationId,int index){
        return affiliationService.getAffiliationAuthors(affiliationId,index);
    }
}
