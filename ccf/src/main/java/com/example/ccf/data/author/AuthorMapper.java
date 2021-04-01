package com.example.ccf.data.author;

import com.example.ccf.po.Affiliation;
import com.example.ccf.po.Author;
import com.example.ccf.po.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface AuthorMapper {

    Author getAuthorById(@Param("author_id")int author_id);

    List<Affiliation> getAuthorAffiliation(@Param("author_id")int author_id);

    /**
     * get Author Papers
     * index已经x10 -> offset
     *
     * @param author_id
     * @param offset
     * @return List<Paper>
     */
    List<Paper> getAuthorPapers(@Param("author_id")int author_id, @Param("offset")int offset);

    List<String> getAuthorMainMeeting(@Param("author_id")int author_id);
}
