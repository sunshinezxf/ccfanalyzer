package com.example.ccf.blImpl.JWT;

import com.auth0.jwt.interfaces.Claim;

public interface JwtUtilsBIService {
      String createToken(String userId,String userName);
    String getUserId(String token);
    Claim getClaimByName(String token, String name);


}
