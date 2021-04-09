package com.example.ccf.bl;

import com.example.ccf.vo.ResponseVO;

public interface StatisticService {

    ResponseVO getStatisticData();

    ResponseVO getAuthorRadar(int authorId);

    ResponseVO getAffiliationRadar(int affiliationId);
}
