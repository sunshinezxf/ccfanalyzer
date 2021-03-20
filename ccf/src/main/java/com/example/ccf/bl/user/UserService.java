package com.example.ccf.bl.user;
import com.example.ccf.vo.*;
public interface UserService {
    /**
     * 注册账号
     * @return
     */
     ResponseVO registerAccount(UserForm userForm);

    /**
     * 用户登录，登录成功会将用户信息保存再session中
     * @return
     */
    UserVO login(UserForm userForm);
    /**
     * 更改密码
     * @return
     */
    ResponseVO change_password(int user_id,String password);

}
