package com.example.ccf.controller.relation;

import com.example.ccf.bl.RelationService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/relationMap")
@CrossOrigin
public class RelationController {

    private RelationService relationService;

    @Autowired
    public void DI(RelationService relationService){
        this.relationService=relationService;
    }

    @RequestMapping(value = "/author/single/{authorId}",method = RequestMethod.GET)
    public ResponseVO authorRelation(@PathVariable int authorId){
        return relationService.getAuthorRelations(authorId);
    }
}
