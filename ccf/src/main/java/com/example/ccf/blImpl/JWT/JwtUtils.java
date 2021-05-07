package com.example.ccf.blImpl.JWT;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;


import java.util.Calendar;
import java.util.Date;

@Service
public class JwtUtils implements JwtUtilsBIService {
    /**
     签发对象：这个用户的id
     签发时间：现在
     有效时间：30分钟
     载荷内容：暂时设计为：这个人的名字，这个人的昵称
     加密密钥：这个人的id加上一串字符串
     */
    @Override
    public  String createToken(String userId,String userName) {

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,30);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(userId)   //签发对象
                .withIssuedAt(new Date())    //发行时间
                .withExpiresAt(expiresDate)  //有效时间
                .withClaim("userName", userName)    //载荷，随便写几个都可以
                .sign(Algorithm.HMAC256(userId+"HelloCCF"));   //加密
    }

    /**
     * 检验合法性，其中secret参数就应该传入的是用户的id
     * @param token
     * @throws
     */

    public  boolean verifyToken(String token, String secret) {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secret+"HelloCCF")).build();
            jwt = verifier.verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 获取签发对象,即userId
     */
    @Override
    public  String getUserId(String token)  {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);

        } catch (JWTDecodeException j) {
            //这里是token解析失败
            return null;
        }
        if(verifyToken(token,audience)){
            return audience;}
            return null;

    }


    /**
     * 通过载荷名字获取载荷的值
     */
    @Override
    public  Claim getClaimByName(String token, String name){
        return JWT.decode(token).getClaim(name);
    }
}
