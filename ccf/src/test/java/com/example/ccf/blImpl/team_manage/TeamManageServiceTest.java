package com.example.ccf.blImpl.team_manage;
import com.example.ccf.bl.team_manage.TeamManageService;
import com.example.ccf.data.team_manage.TeamManageMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamManageServiceTest {
    @Autowired
    private TeamManageServiceImpl teamManageService;
//    @Test
//    public void team_create(){
//        // System.out.println(teamManageService.team_create(3,"test_team").getContent());
//        //上面用于创建，已有时则只需一个。
//        System.out.println(teamManageService.team_create(3,"test_team").getContent());
//    }
//    @Test
//    public void team_invite(){
//       // System.out.println(teamManageService.team_invite(3,"xiaohong",1).getContent());
//        //上面用于创建，已有时则只需一个。
//        System.out.println(teamManageService.team_invite(3,"xiaohong",1).getContent());
//        System.out.println(teamManageService.team_invite(3,"xiaohong1",1).getContent());
//        System.out.println(teamManageService.team_invite(2,"xiaohong",1).getContent());
//
//    }
//    @Test
//    public void owner_if(){
//        System.out.println(teamManageService.team_owner_check(2,1).getContent());
//        System.out.println(teamManageService.team_owner_check(3,1).getContent());
//    }
//    @Test
//    public void team_list(){
//        teamManageService.team_list(4);
//        teamManageService.team_list(3);
//    }
//    @Test
//    public void team_member(){
//        teamManageService.team_members(1);
//    }
//    @Test
//    public void team_quit(){
//        System.out.println(teamManageService.team_quit(2,1).getContent());
//        System.out.println(teamManageService.team_quit(4,1).getContent());
//    }
//    @Test
//    public void team_member_quit(){
//        teamManageService.team_invite(3,"xiaohong",1);
//        System.out.println(teamManageService.team_member_quit(3,"xiaohong1",1).getContent());
//        System.out.println(teamManageService.team_member_quit(4,"xiaohong",1).getContent());
//        System.out.println(teamManageService.team_member_quit(3,"xiaohong",1).getContent());
//
//    }
//    @Test
//    public void team_dismiss(){
//        System.out.println(teamManageService.team_dismiss(4,1).getContent());
//        System.out.println(teamManageService.team_dismiss(3,3).getContent());
//    }
    @Test
    public void test(){
        System.out.println();
    }
}
