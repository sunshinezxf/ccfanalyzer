package com.example.ccf.controller.team_manage;
import com.example.ccf.bl.team_manage.TeamManageService;
import com.example.ccf.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/team")
public class TeamManageController {
    @Autowired
    private TeamManageService teamManageService;
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/create",method = RequestMethod.GET)
    public ResponseVO team_create(int user_id,String team_name){
        return teamManageService.team_create(user_id, team_name);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/invite",method = RequestMethod.GET)
    public ResponseVO team_invite(int user_id,String invitee,int team_id){
        return teamManageService.team_invite(user_id, invitee, team_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/quit",method = RequestMethod.GET)
    public ResponseVO team_quit(int user_id, int team_id){
        return teamManageService.team_quit(user_id, team_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/delete",method = RequestMethod.GET)
    public ResponseVO team_delete(int user_id,int team_id){
        return teamManageService.team_dismiss(user_id, team_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/memberDelete",method = RequestMethod.GET)
    public ResponseVO team_member_delete(int user_id,String member,int team_id){
        return teamManageService.team_member_quit(user_id, member, team_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/list",method = RequestMethod.GET)
    public ResponseVO team_list(int user_id){
        return teamManageService.team_list(user_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/members",method = RequestMethod.GET)
    public ResponseVO team_members(int team_id){
        return teamManageService.team_members(team_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/owner/check",method = RequestMethod.GET)
    public ResponseVO team_owner_check(int user_id,int team_id){
        return teamManageService.team_owner_check(user_id, team_id);
    }

}
