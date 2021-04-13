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
    @PostMapping("/login")
    public ResponseVO login(UserForm userForm, HttpSession session){
       UserVO userVO= userService.login(userForm);
       if(userVO==null){
           return ResponseVO.buildSuccess("用户名或者密码错误");
       }
       else{
//           System.out.println(session.getId());
           String token=userVO.getPassword();
           session.setAttribute(token,userVO);
           session.setMaxInactiveInterval(1800);//session过期时间半小时
           return ResponseVO.buildSuccess(token);
       }
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/logout",method = RequestMethod.POST)
    public ResponseVO logout(String token,HttpSession session){
        session.removeAttribute(token);
        return ResponseVO.buildSuccess("登出成功。");
    }
    @CrossOrigin(origins="*",maxAge=3600)
    @RequestMapping(value ="/register",method = RequestMethod.POST)
    public ResponseVO register(UserForm userForm){
        return  userService.registerAccount(userForm);
    }

}
