package com.txy.dao;

import com.txy.domain.User;

public interface UserMapper {
    //根据用户名查询用户信息
    User findByUsername(User user);

    //按用户名和密码查找用户--登录
    User findByUsernameAndPassword(User user);

    //添加新用户--注册
    int insert(User user);

    //修改用户信息
    int update(User user);



    //boolean delete(User user);
    //查询所有用户
    //List<User> findAll();
}
