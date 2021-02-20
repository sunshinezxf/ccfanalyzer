package com.example.ccf.blImpl;

import com.example.ccf.bl.AffiliationService;
import com.example.ccf.data.affiliation.AffiliationMapper;
import com.example.ccf.data.author.AuthorMapper;
import com.example.ccf.po.Affiliation;
import com.example.ccf.vo.AffiliationPortrait;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AffiliationServiceImpl implements AffiliationService {

    private AffiliationMapper affiliationMapper;

    @Autowired
    public void DI(AffiliationMapper affiliationMapper){
        this.affiliationMapper=affiliationMapper;
    }

    @Override
    public ResponseVO getAffiliationPortrait(int affiliationId) {

        AffiliationPortrait affiliationPortrait=new AffiliationPortrait();

        Affiliation affiliation=affiliationMapper.getAffiliationById(affiliationId);

        affiliationPortrait.setAffiliationId(affiliation.getAffiliation_id());
        affiliationPortrait.setName(affiliation.getAffiliation());

        //TODO

        return ResponseVO.buildSuccess(affiliationPortrait);
    }

    @Override
    public ResponseVO getAffiliationRelatedPapers(int affiliationId,int index) {
        return null;
    }
}
