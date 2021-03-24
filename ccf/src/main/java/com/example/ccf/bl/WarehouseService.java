package com.example.ccf.bl;

import com.example.ccf.vo.ResponseVO;

public interface WarehouseService {

    ResponseVO getPrivatePapers();

    ResponseVO getTeamPapers();

    ResponseVO deletePaper(int privatePaperId);
}
