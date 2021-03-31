package com.example.ccf.bl.team_manage;

import com.example.ccf.vo.ResponseVO;

public interface TeamManageService {
    //创建团队
    ResponseVO team_create(int user_id,String team_name);
    //邀请成员加入,默认直接加入
    ResponseVO team_invite(int user_id,String invitee,int team_id);
    //退出团队
    ResponseVO team_quit(int user_id, int team_id);
    //解散团队
    ResponseVO team_dismiss(int user_id,int team_id);
    //踢出团队
    ResponseVO team_member_quit(int user_id,String member,int team_id);
    //查看加入的团队
    ResponseVO team_list(int user_id);
    //查看某一团队的所有成员
    ResponseVO team_members(int team_id);
    //查看是否是某个团队的队长
    ResponseVO team_owner_check(int user_id,int team_id);
}
