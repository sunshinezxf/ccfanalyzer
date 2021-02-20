package com.example.ccf.data.affiliation;

import com.example.ccf.po.Affiliation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AffiliationMapper {

    Affiliation getAffiliationById (@Param("affiliation_id")int affiliation_id);

}
