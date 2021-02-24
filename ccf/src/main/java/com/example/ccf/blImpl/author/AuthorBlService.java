package com.example.ccf.blImpl.author;

import com.example.ccf.vo.AffiliationOmit;

import java.util.List;

public interface AuthorBlService {

    List<AffiliationOmit> getAuthorAffiliation(int authorId);
}
