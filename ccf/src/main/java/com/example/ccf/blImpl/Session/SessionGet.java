package com.example.ccf.blImpl.Session;

import com.example.ccf.vo.UserVO;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class SessionGet implements SessionBIService{
    private ConcurrentHashMap<String,HttpSession> map = new ConcurrentHashMap();
    @Override
    public int get_id(String token){
        HttpSession session=getSession(token);
        if(session==null)
            return 0;
        UserVO userVO=(UserVO) session.getAttribute(token);
        if(userVO==null){
            return 0;
        }
        else{
            return userVO.getId();
        }
    }
    @Override
    public String get_username(String token){
        HttpSession session=getSession(token);
        if(session==null)
            return "0";
        UserVO userVO=(UserVO) session.getAttribute(token);
        if(userVO==null){
            return "0";
        }
        else{
            return userVO.getUsername();
        }
    }


    @Override
    public synchronized void AddSession(HttpSession session, String token) {

            map.remove(token);
            map.put(token, session);

    }
    @Override
    public  synchronized void DelSession(String token) {
            map.remove(token);
    }
    @Override
    public synchronized HttpSession getSession(String token) {
        if (token == null)
            return null;
        return (HttpSession) map.get(token);
    }
}
