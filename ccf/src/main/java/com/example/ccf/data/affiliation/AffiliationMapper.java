package com.example.ccf.data.affiliation;

import com.example.ccf.po.Affiliation;
import com.example.ccf.po.Author;
import com.example.ccf.po.Paper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Mapper
@Repository
public interface AffiliationMapper {

    Affiliation getAffiliationById (@Param("affiliation_id")int affiliation_id);

    // index已经x10 -> offset
    List<Paper> getAffiliationPapers(@Param("affiliation_id")int affiliation_id, @Param("offset")int offset);

    // index已经x10 -> offset
    List<Author> getAffiliationAuthors(@Param("affiliation_id")int affiliation_id, @Param("offset")int offset);

    List<String> getAffiliationMainMeeting(@Param("affiliation_id")int affiliation_id);
}
