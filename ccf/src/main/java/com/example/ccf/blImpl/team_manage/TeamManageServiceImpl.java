package com.example.ccf.blImpl.team_manage;

import com.example.ccf.bl.team_manage.TeamManageService;
import com.example.ccf.blImpl.JWT.JwtUtilsBIService;
import com.example.ccf.blImpl.Session.SessionBIService;
import com.example.ccf.data.team_manage.TeamManageMapper;
import com.example.ccf.po.TeamInf;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamManageServiceImpl implements TeamManageService,TeamManageBlService {
    @Autowired
    private JwtUtilsBIService jwtUtilsBIService;
    @Autowired
    private TeamManageMapper teamManageMapper;
    @Autowired
    private SessionBIService sessionBIService;
    @Override
    public ResponseVO team_create(String token, String team_name){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        Integer id=teamManageMapper.find_team_id(team_name);
        if(id==null) {
            teamManageMapper.team_create(user_id, team_name);
            teamManageMapper.team_invite(user_id, teamManageMapper.find_team_id(team_name));
            return ResponseVO.buildSuccess("建立成功");
        }
        else{
            return ResponseVO.buildSuccess("该团队名称已被使用");
        }
    }
    @Override
    public ResponseVO team_invite(String token,String invitee,int team_id){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        Integer id=teamManageMapper.find_id(invitee);
        if(id==null){
            return ResponseVO.buildSuccess("邀请对象不存在");
        }
        else{
            int right=teamManageMapper.right_if(user_id, team_id);
            if(right>=1) {
                Integer member_if=teamManageMapper.member_if(id,team_id);
                if(member_if>=1){
                    return ResponseVO.buildSuccess("该用户已经是该团队的成员。");
                }
                teamManageMapper.team_invite(id,team_id);
                return ResponseVO.buildSuccess("该用户已成功加入此团队！");
            }
            else{
                return  ResponseVO.buildSuccess("你无权邀请该用户加入此团队。");
            }
        }
    }
    @Override
    public ResponseVO team_quit(String token, int team_id){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        Integer id=teamManageMapper.member_if(user_id, team_id);
        if(id==0){
            return  ResponseVO.buildSuccess("你不是该团队的成员！");
        }
        else{
            int right=teamManageMapper.right_if(user_id, team_id);
            if(right>=1){
                return team_dismiss(token,team_id);
            }
            teamManageMapper.team_quit(user_id, team_id);
            return ResponseVO.buildSuccess("你已经成功退出该团队。");
        }
    }
    @Override
    public ResponseVO team_dismiss(String token,int team_id){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        int right=teamManageMapper.right_if(user_id, team_id);
        if(right>=1){
            teamManageMapper.team_dismiss(team_id);
            teamManageMapper.team_members_quit(team_id);
            teamManageMapper.team_paper_delete(team_id);
            teamManageMapper.team_paper_relation_delete(team_id);
            return ResponseVO.buildSuccess("团队已经解散，团队仓库内文章已删除。");
        }
        else{
            return ResponseVO.buildSuccess("你无权解散该团队");
        }
    }
    @Override
    public ResponseVO team_member_quit(String token,String member,int team_id){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        int right=teamManageMapper.right_if(user_id, team_id);
        if(right>=1){
            Integer id=teamManageMapper.find_id(member);
            if(id==null){
                return ResponseVO.buildSuccess("该团队内没有此成员。");
            }
            else{
                teamManageMapper.team_member_quit(id,team_id);
                return ResponseVO.buildSuccess("已将该成员提出团队。");
            }
        }
        else{
            return ResponseVO.buildSuccess("你没有权限踢出该成员。");
        }
    }
    @Override
    public ResponseVO team_list(String token){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        List<TeamInf> teamInf=teamManageMapper.team_list(user_id);
        return ResponseVO.buildSuccess(teamInf);
    }
    @Override
    public ResponseVO team_members(int team_id){
        List<String> members=teamManageMapper.team_members(team_id);
        return ResponseVO.buildSuccess(members);
    }
    @Override
    public ResponseVO team_owner_check(String token,int team_id){
        String userId=jwtUtilsBIService.getUserId(token);
        int user_id=0;
        if(userId!=null){
            user_id=Integer.parseInt(userId);
        }
        if(user_id==0){
            return ResponseVO.buildSuccess("该用户未登录");
        }
        int right=teamManageMapper.right_if(user_id, team_id);
        if(right>=1){
            return ResponseVO.buildSuccess(1);
        }
        else{
            return ResponseVO.buildSuccess(0);
        }
    }

    @Override
    public boolean isOwner(int user_id, int team_id) {
        int right=teamManageMapper.right_if(user_id, team_id);
        if(right>=1){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean isInTeam(int userId, int teamId) {

        Integer member_if=teamManageMapper.member_if(userId,teamId);
        if(member_if>=1){
            return true;
        }
        else
            return false;
    }
}
