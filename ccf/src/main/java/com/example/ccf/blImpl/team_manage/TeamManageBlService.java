package com.example.ccf.blImpl.team_manage;

public interface TeamManageBlService {

    boolean isOwner(int userId, int teamId);

    boolean isInTeam(int userId, int teamId);
}