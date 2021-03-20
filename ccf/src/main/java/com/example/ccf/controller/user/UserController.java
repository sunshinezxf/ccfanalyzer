package com.example.ccf.controller.user;
import com.example.ccf.bl.search.SearchService;
import com.example.ccf.bl.user.UserService;
import com.example.ccf.po.CommonSearch;
import com.example.ccf.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/login",method = RequestMethod.GET)
    public ResponseVO login(@RequestBody UserForm userForm, HttpSession session){
       UserVO userVO= userService.login(userForm);
       if(userVO==null){
           return ResponseVO.buildSuccess("用户名或者密码错误");
       }
       else{
           session.setAttribute("user_inf",userVO);
           session.setMaxInactiveInterval(3600);//session过期时间一小时
           return ResponseVO.buildSuccess(userVO);
       }
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/logout",method = RequestMethod.GET)
    public ResponseVO logout(HttpSession session){
        session.removeAttribute("user_inf");
        return ResponseVO.buildSuccess("登出成功。");
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/register",method = RequestMethod.GET)
    public ResponseVO register(UserForm userForm){
        return  userService.registerAccount(userForm);
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/change_password",method = RequestMethod.GET)
    public ResponseVO change_password(int user_id,String password){
        return  userService.change_password(user_id,password);
    }
}
