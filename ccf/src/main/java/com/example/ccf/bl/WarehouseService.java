package com.example.ccf.bl;

import com.example.ccf.vo.ResponseVO;

public interface WarehouseService {

    ResponseVO getPrivatePapers(String token);

    ResponseVO getTeamPapers(String token,int teamId);

    ResponseVO deleteTeamPaper(int privatePaperId,String token);

    ResponseVO deletePrivatePaper(int privatePaperId,String token);
}
