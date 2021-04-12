package com.example.ccf.data.relation;

import com.example.ccf.po.AuthorRelation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface RelationMapper {

    List<AuthorRelation> getRelations(@Param("author_id") int author_id);

    int getMaxCoopRelation(@Param("author_id") int author_id);
}
