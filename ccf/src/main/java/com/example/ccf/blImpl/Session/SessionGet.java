package com.example.ccf.blImpl.Session;

import com.example.ccf.vo.UserVO;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Service
public class SessionGet implements SessionBIService{
    @Override
    public int get_id(String token){
        UserVO userVO=get_user(token);
        if(userVO==null){
            return 0;
        }
        else{
            return userVO.getId();
        }
    }
    @Override
    public String get_username(String token){
        UserVO userVO=get_user(token);
        if(userVO==null){
            return "0";
        }
        else{
            return userVO.getUsername();
        }
    }

    public UserVO get_user(String token){
        HttpServletRequest httpServletRequest=getRequest();
        HttpSession session=httpServletRequest.getSession();
        UserVO userForm=(UserVO) session.getAttribute(token);
        return userForm;

    }
    public static HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;

    }
}
