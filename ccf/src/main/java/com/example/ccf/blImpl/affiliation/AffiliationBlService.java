package com.example.ccf.blImpl.affiliation;

public interface AffiliationBlService {

    double getAveAffiliationCitationNum(int affiliationId);

    int getMaxAffiliationCitationNum(int affiliationId);

    double getAveAffiliationArticleNum(int affiliationId);

    int getMaxAffiliationArticleNum(int affiliationId);
}
