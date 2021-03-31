package com.example.ccf.data.user;
import com.example.ccf.po.SegmentationTitle;
import com.example.ccf.vo.UserForm;
import com.example.ccf.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    /**
     * find user
     *
     * @param username
     * @return
     */
    String can_get_username(@Param("username") String username);
    /**
     * find password
     *
     * @param username
     * @return
     */
    String get_pass(@Param("username") String username);
    /**
     * change password
     *
     * @param
     * @return
     */
    void change_pass(@Param("user_id") int user_id,@Param("password") String password);
    /**
     * register
     *
     * @param
     * @return
     */
    void user_register(UserForm userForm);
    /**
     * login
     *
     * @param username
     * @return
     */
    UserVO login(@Param("username") String username);
    /**
     * find username
     *
     * @param id
     * @return
     */
    String get_username(@Param("id") int id);




}
