package com.txy.mapper;

import com.txy.domain.User;

import java.util.List;

public interface UserMapper {

    //查询所有用户信息
    List<User> findAll();

    //根据用户名查询用户信息
    User findByUsername(String username);

    //按用户名和密码查找用户--登录
    User findByUsernameAndPassword(User user);

    //添加新用户--注册
    int insert(User user);

    //修改用户密码
    int updatePassword(User user);

    //修改用户信息
    int update(User user);

    int delete(String username);

    List<User> findByConditions(User user);

}
