package com.example.ccf.blImpl.Session;

import javax.servlet.http.HttpSession;

public interface SessionBIService {
    int get_id(String token);
    String get_username(String token);
    void AddSession(HttpSession session, String token);
    void DelSession(String token);
    HttpSession getSession(String token);
}
