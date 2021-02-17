package com.example.ccf.data.author;

import com.example.ccf.po.Affiliation;
import com.example.ccf.po.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface AuthorMapper {

    Author getAuthorById(@Param("author_id")int author_id);

    List<Affiliation> getAuthorAffiliation(@Param("author_id")int author_id);

}
