package com.example.ccf.data.team_manage;

import com.example.ccf.po.TeamInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeamManageMapper {
    //创建团队
    void team_create(@Param("user_id") int user_id, @Param("team_name") String team_name);
    //邀请人进入团队
    void team_invite(@Param("invitee_id") int invitee_id,@Param("team_id") int team_id);
    //退出团队
    void team_quit(@Param("user_id") int user_id,@Param("team_id") int team_id);
    //解散团队，包括删除团队，团队中的人物，团队中的文章
    void team_dismiss(@Param("team_id") int team_id);
    void team_members_quit(@Param("team_id") int team_id);
    void team_paper_delete(@Param("team_id") int team_id);
    void team_paper_relation_delete(@Param("team_id") int team_id);
    //踢出某人
    void team_member_quit(@Param("user_id") int user_id,@Param("team_id") int team_id);
    //确认权限
    Integer find_id(@Param("username") String username);
    int right_if(@Param("user_id") int user_id,@Param("team_id") int team_id);
    int member_if(@Param("user_id") int user_id,@Param("team_id") int team_id);
    Integer find_team_id(@Param("team_name") String team_name);
    //显示团队信息
    List<TeamInf> team_list(int user_id);
    List<String> team_members(int team_id);
}
