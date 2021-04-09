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
    @RequestMapping(value ="/create",method = RequestMethod.POST)
    public ResponseVO team_create(String token,String team_name){
        return teamManageService.team_create(token, team_name);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/invite",method = RequestMethod.POST)
    public ResponseVO team_invite(String token,String invitee,int team_id){
        return teamManageService.team_invite(token, invitee, team_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/quit",method = RequestMethod.POST)
    public ResponseVO team_quit(String token, int team_id){
        return teamManageService.team_quit(token, team_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/delete",method = RequestMethod.POST)
    public ResponseVO team_delete(String token,int team_id){
        return teamManageService.team_dismiss(token, team_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/memberDelete",method = RequestMethod.POST)
    public ResponseVO team_member_delete(String token,String member,int team_id){
        return teamManageService.team_member_quit(token, member, team_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/list",method = RequestMethod.GET)
    public ResponseVO team_list(String token){
        return teamManageService.team_list(token);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/members",method = RequestMethod.GET)
    public ResponseVO team_members(int team_id){
        return teamManageService.team_members(team_id);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/owner/check",method = RequestMethod.GET)
    public ResponseVO team_owner_check(String token,int team_id){
        return teamManageService.team_owner_check(token, team_id);
    }

}
