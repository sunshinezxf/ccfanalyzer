package com.example.ccf.bl;

import com.example.ccf.vo.ResponseVO;

public interface AuthorService {

    ResponseVO getAuthorPortrait(int authorId);

    ResponseVO getAuthorRelatedPapers(int authorId,int index);

}
