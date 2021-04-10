package com.example.ccf.blImpl.relation;

import com.example.ccf.bl.RelationService;
import com.example.ccf.data.relation.RelationMapper;
import com.example.ccf.po.AuthorRelation;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RelationServiceImpl implements RelationService,RelationBlService{

    private RelationMapper relationMapper;

    @Autowired
    public void DI(RelationMapper relationMapper){
        this.relationMapper=relationMapper;
    }

    @Override
    public ResponseVO getAuthorRelations(int authorId) {
        return null;
    }

    @Override
    public double getAveRelation(int authorId) {
        List<AuthorRelation> relations=relationMapper.getRelations(authorId);
        int coops=0;
        for(AuthorRelation authorRelation:relations){
            coops=coops+authorRelation.getCoop_time();
        }
        return (double) coops/((double) relations.size());
    }

    @Override
    public int getMaxRelation(int authorId) {
        return relationMapper.getMaxCoopRelation(authorId);
    }
}
