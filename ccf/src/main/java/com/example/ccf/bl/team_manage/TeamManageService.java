package com.example.ccf.bl.team_manage;

import com.example.ccf.vo.ResponseVO;

public interface TeamManageService {
    //创建团队
    ResponseVO team_create(String token,String team_name);
    //邀请成员加入,默认直接加入
    ResponseVO team_invite(String token,String invitee,int team_id);
    //退出团队
    ResponseVO team_quit(String token, int team_id);
    //解散团队
    ResponseVO team_dismiss(String token,int team_id);
    //踢出团队
    ResponseVO team_member_quit(String token,String member,int team_id);
    //查看加入的团队
    ResponseVO team_list(String token);
    //查看某一团队的所有成员
    ResponseVO team_members(int team_id);
    //查看是否是某个团队的队长
    ResponseVO team_owner_check(String token,int team_id);
}
