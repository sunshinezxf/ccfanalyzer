package com.example.ccf.blImpl.warehouse;

import com.example.ccf.bl.WarehouseService;
import com.example.ccf.blImpl.Session.SessionBIService;
import com.example.ccf.blImpl.team_manage.TeamManageBlService;
import com.example.ccf.data.warehouse.WarehouseMapper;
import com.example.ccf.po.Paper;
import com.example.ccf.vo.Private_paper;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedList;
import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {

    private SessionBIService sessionBIService;
    private WarehouseMapper warehouseMapper;
    private TeamManageBlService teamManageBlService;

    @Autowired
    public void DI(SessionBIService sessionBIService,WarehouseMapper warehouseMapper,TeamManageBlService teamManageBlService){
        this.sessionBIService=sessionBIService;
        this.warehouseMapper=warehouseMapper;
        this.teamManageBlService=teamManageBlService;
    }

    @Override
    public ResponseVO getPrivatePapers(String token) {

        int userId=sessionBIService.get_id(token);
        if(userId==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }

        List<Paper> papers=warehouseMapper.getUserPrivatePaper(userId);

        return ResponseVO.buildSuccess(privatePaperFactory(papers));
    }

    @Override
    public ResponseVO getTeamPapers(String token,int teamId) {

        int userId=sessionBIService.get_id(token);
        if(userId==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        if(!teamManageBlService.isInTeam(userId,teamId)){
            return ResponseVO.buildSuccess("该用户不属于这个团队");
        }

        List<Paper> papers=warehouseMapper.getTeamPrivatePaper(teamId);
        return ResponseVO.buildSuccess(privatePaperFactory(papers));
    }

    @Override
    public ResponseVO deleteTeamPaper(int privatePaperId, String token) {

        int userId=sessionBIService.get_id(token);
        if(userId==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }

        int teamId=warehouseMapper.getPaperTeam(privatePaperId);
        if(teamManageBlService.isOwner(userId,teamId)){

            warehouseMapper.deletePrivatePaper(privatePaperId);
            warehouseMapper.deleteTeamRelation(privatePaperId);

            return ResponseVO.buildSuccess("删除成功");
        }else {
            return ResponseVO.buildSuccess("没有删除权限");
        }

    }

    @Override
    public ResponseVO deletePrivatePaper(int privatePaperId, String token) {

        int userId=sessionBIService.get_id(token);
        if(userId==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }

        int ownerId=warehouseMapper.getPaperOwner(privatePaperId);

        if(ownerId==userId){

            warehouseMapper.deletePrivatePaper(privatePaperId);
            warehouseMapper.deleteUserRelation(privatePaperId);

            return ResponseVO.buildSuccess("删除成功");
        }else {

            return ResponseVO.buildSuccess("没有删除权限");
        }
    }

    private List<Private_paper> privatePaperFactory(List<Paper> papers){
        List<Private_paper> private_papers=new LinkedList<>();
        for(Paper paper:papers){

            Private_paper private_paper=new Private_paper();
            List<String> authors=warehouseMapper.getPrivatePaperAuthors(paper.getPaper_id());
            private_paper.setAuthors(authors);
            private_paper.setPaper_id(paper.getPaper_id());
            private_paper.setAbstracts(paper.getAbstract());
            private_paper.setBib_source(paper.getBib_source());
            private_paper.setPages(paper.getPages());
            private_paper.setBib_url(paper.getBib_url());
            private_paper.setCitation(paper.getCitation());
            private_paper.setBook_title(paper.getBook_title());
            private_paper.setPublisher(paper.getPublisher());
            private_paper.setTime(paper.getTime());
            private_paper.setTitle(paper.getTitle());
            private_paper.setDoi(paper.getDoi());
            private_paper.setYear(paper.getYear());
            private_paper.setUrl(paper.getUrl());

            private_papers.add(private_paper);
        }
        return private_papers;
    }
}
