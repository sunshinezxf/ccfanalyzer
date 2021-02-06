package com.example.ccf.data.author;

import com.example.ccf.po.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AuthorMapper {

    Author getAuthorBuId(@Param("author_id")int author_id);

}
