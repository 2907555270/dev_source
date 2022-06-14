package com.txy.service;

import com.github.pagehelper.PageInfo;
import com.txy.domain.User;


public interface UserService {
    PageInfo<User> findAll(int currentPage,int pageSize);

    PageInfo<User> findByConditions(User user, int currentPage, int pageSize);

    User findByUsername(User user);

    User login(String username,String password);

    boolean updatePassword(User user);

    boolean update(User user);

    boolean register(User user);

    boolean delete(String username);
}
