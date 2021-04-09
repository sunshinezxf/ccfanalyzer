package com.example.ccf.blImpl.warehouse;

import com.example.ccf.bl.AffiliationService;
import com.example.ccf.bl.AuthorService;
import com.example.ccf.bl.ConferenceService;
import com.example.ccf.bl.WarehouseService;
import com.example.ccf.blImpl.Session.SessionBIService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private SessionBIService sessionBIService;

    @Autowired
    public void DI(SessionBIService sessionBIService){
        this.sessionBIService=sessionBIService;
    }

    @Override
    public ResponseVO getPrivatePapers(String token) {

        int userId=sessionBIService.get_id(token);;
        if(userId==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }



        return null;
    }

    @Override
    public ResponseVO getTeamPapers(String token) {
        int userId=sessionBIService.get_id(token);;
        if(userId==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }


        return null;
    }

    @Override
    public ResponseVO deletePaper(int privatePaperId,String token) {
        int userId;
        return null;
    }
}
