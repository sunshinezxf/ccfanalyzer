package com.example.ccf.blImpl.relation;

import com.example.ccf.bl.RelationService;
import com.example.ccf.blImpl.author.AuthorBlService;
import com.example.ccf.data.relation.RelationMapper;
import com.example.ccf.po.AuthorRelation;
import com.example.ccf.vo.ResponseVO;
import com.example.ccf.vo.relation.AuthorInfo;
import com.example.ccf.vo.relation.AuthorRelationPortrait;
import com.example.ccf.vo.relation.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class RelationServiceImpl implements RelationService,RelationBlService{

    private RelationMapper relationMapper;
    private AuthorBlService authorBlService;

    @Autowired
    public void DI(RelationMapper relationMapper,AuthorBlService authorBlService){
        this.relationMapper=relationMapper;
        this.authorBlService=authorBlService;
    }

    @Override
    public ResponseVO getAuthorRelations(int authorId) {

        AuthorRelationPortrait authorRelationPortrait=new AuthorRelationPortrait();

        List<Connection> connections=new LinkedList<>();
        List<AuthorInfo> authors=new LinkedList<>();

        AuthorInfo sourceAuthorInfo=new AuthorInfo();
        sourceAuthorInfo.setName(authorBlService.getAuthorName(authorId));
        sourceAuthorInfo.setValue(authorBlService.getAuthorValue(authorId)*10);

        authors.add(sourceAuthorInfo);

        List<AuthorRelation> authorRelations=relationMapper.getRelations(authorId);


        for(AuthorRelation authorRelation:authorRelations){

            Connection connection=new Connection();
            AuthorInfo targetAuthorInfo=new AuthorInfo();

            if(authorRelation.getAuthor_one_id()==authorId){

                connection.setTarget(authorBlService.getAuthorName(authorRelation.getAuthor_two_id()));
                targetAuthorInfo.setName(authorBlService.getAuthorName(authorRelation.getAuthor_two_id()));
                targetAuthorInfo.setValue(authorBlService.getAuthorValue(authorRelation.getAuthor_two_id()));
            }else {

                connection.setTarget(authorBlService.getAuthorName(authorRelation.getAuthor_one_id()));
                targetAuthorInfo.setName(authorBlService.getAuthorName(authorRelation.getAuthor_one_id()));
                targetAuthorInfo.setValue(authorBlService.getAuthorValue(authorRelation.getAuthor_one_id()));
            }


            connection.setSource(authorBlService.getAuthorName(authorId));
            connections.add(connection);
            authors.add(targetAuthorInfo);
        }

        authorRelationPortrait.setAuthors(authors);
        authorRelationPortrait.setConnections(connections);
        return ResponseVO.buildSuccess(authorRelationPortrait);
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
