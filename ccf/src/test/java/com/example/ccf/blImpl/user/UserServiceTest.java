package com.example.ccf.blImpl.user;
import com.example.ccf.vo.UserForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserServiceImpl userService;
//    @Test
//    public void register_test(){
//        UserForm userForm=new UserForm();
//        userForm.setPassword("simple");
//        userForm.setUser_name("xiaohong");
//        System.out.println(userService.registerAccount(userForm).getContent());
//    }
//    @Test
//    public  void change_password(){
//        System.out.println(userService.change_password(2,"hard").getContent());
//    }
//    @Test
//    public void login_fail(){
//        UserForm userForm=new UserForm();
//        userForm.setPassword("hard");
//        userForm.setUser_name("xiaoming");
//        System.out.println(userService.login(userForm).getUser_name());
//    }
//    @Test
//    public void login_success(){
//        UserForm userForm=new UserForm();
//        userForm.setPassword("simple");
//        userForm.setUser_name("xiaoming");
//        System.out.println(userService.login(userForm).getUser_name());
//    }
    @Test
    public void test(){
        System.out.println();
    }


}
