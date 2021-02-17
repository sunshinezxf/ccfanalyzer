package com.example.ccf.bl;

import com.example.ccf.vo.ResponseVO;

public interface AffiliationService {

    ResponseVO getAffiliationPortrait(int affiliationId);

    ResponseVO getAffiliationRelatedPapers(int affiliationId,int index);

}
