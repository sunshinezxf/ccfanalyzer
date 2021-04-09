package com.example.ccf.bl;

import com.example.ccf.vo.ResponseVO;

public interface WarehouseService {

    ResponseVO getPrivatePapers(String token);

    ResponseVO getTeamPapers(String token);

    ResponseVO deletePaper(int privatePaperId,String token);
}