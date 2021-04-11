package com.example.ccf.blImpl.author;

import com.example.ccf.vo.AffiliationOmit;

import java.util.List;

public interface AuthorBlService {

    List<AffiliationOmit> getAuthorAffiliation(int authorId);

    double getAuthorAveCitation(int authorId);

    int getMaxAuthorCitation(int authorId);

    List<Integer> getPaperNumGroupByYear(int authorId);

    int getAuthorValue(int authorId);

    String getAuthorName(int authorId);
}
