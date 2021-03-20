package com.example.ccf.blImpl.user;

import com.example.ccf.bl.user.UserService;
import com.example.ccf.data.user.UserMapper;
import com.example.ccf.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public ResponseVO registerAccount(UserForm userForm){
        String name=userForm.getUser_name();
        String password=userForm.getPassword();
        String username=userMapper.can_get_username(name);
        if(username!=null){
            return ResponseVO.buildSuccess("用户名已被注册");
        }
        else{
            password=md5(password,name);
            userForm.setPassword(password);
            userMapper.user_register(userForm);
            return ResponseVO.buildSuccess("成功注册！");
        }
    }

    @Override
    public UserVO login(UserForm userForm){
        String name=userForm.getUser_name();
        String password=userForm.getPassword();
        if(md5(password,name).equals(userMapper.get_pass(name))){
            return  userMapper.login(name);
        }
        else{
            return new UserVO();
        }
    }
    @Override
    public ResponseVO change_password(int user_id,String password){
        String name=userMapper.get_username(user_id);
        userMapper.change_pass(user_id,md5(password,name));
        return ResponseVO.buildSuccess("修改成功");
    }


    public static final String md5(String password, String salt){
        //加密方式
        String hashAlgorithmName = "MD5";
        //盐：相同密码使用不同的盐加密后的结果不同,为用户名
        ByteSource byteSalt = ByteSource.Util.bytes(salt);
        //密码
        Object source = password;
        //加密次数
        int hashIterations = 2;
        SimpleHash result = new SimpleHash(hashAlgorithmName, source, byteSalt, hashIterations);
        return result.toString();
    }
}
