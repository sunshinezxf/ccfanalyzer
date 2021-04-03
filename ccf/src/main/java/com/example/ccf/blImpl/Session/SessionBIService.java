package com.example.ccf.blImpl.Session;

public interface SessionBIService {
    int get_id(String token);
    String get_username(String token);
}
