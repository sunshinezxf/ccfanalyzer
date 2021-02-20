package com.example.ccf.controller.portrait;

import com.example.ccf.bl.AffiliationService;
import com.example.ccf.bl.AuthorService;
import com.example.ccf.bl.ConferenceService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/portrait")
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

    @RequestMapping(value = "/conference/{name}",method = RequestMethod.GET)
    public ResponseVO conferencePortrait(@PathVariable String name){
        // TODO
        return conferenceService.getConferencePortrait(1);
    }

    @RequestMapping(value = "/author/papers",method = RequestMethod.GET)
    public ResponseVO authorRelatedPapers(int authorId,int index){
        return authorService.getAuthorRelatedPapers(authorId,index);
    }

    @RequestMapping(value = "/conference/papers",method = RequestMethod.GET)
    public ResponseVO conferenceRelatedPapers(String name,int index){
        // TODO
        return conferenceService.getConferenceRelatedPapers(1,index);
    }

    @RequestMapping(value = "/affiliation/papers",method = RequestMethod.GET)
    public ResponseVO affiliationRelatedPapers(int affiliationId,int index){
        return authorService.getAuthorRelatedPapers(affiliationId,index);
    }
}
