package com.example.ccf.blImpl.Session;

import com.example.ccf.vo.UserVO;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Service
public class SessionGet implements SessionBIService{
    private static HashMap mymap = new HashMap();
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
        if (session != null) {
            mymap.put(token, session);
        }
    }
    @Override
    public  synchronized void DelSession(String token) {
            mymap.remove(token);
    }
    @Override
    public synchronized HttpSession getSession(String token) {
        if (token == null)
            return null;
        return (HttpSession) mymap.get(token);
    }
}
