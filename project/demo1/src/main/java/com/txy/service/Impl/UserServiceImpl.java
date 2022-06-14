package com.txy.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.txy.mapper.UserMapper;
import com.txy.domain.User;
import com.txy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    /**
     * 分页查询所有信息
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<User> findAll(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> users = mapper.findByConditions(null);
        return new PageInfo<>(users);
    }

    /**
     * 模糊查询 username\email\name + 精确查找 age
     * @param user
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public PageInfo<User> findByConditions(User user, int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<User> users = mapper.findByConditions(user);
        return new PageInfo<>(users);
    }

    /**
     * 登录：对 username + password 精确匹配
     * @param username
     * @param password
     * @return
     */
    @Override
    public User login(String username,String password) {
        User user = new User();
        if(username!=null&&password!=null){
            user.setUsername(username);
            user.setPassword(password);
        }
        return mapper.findByUsernameAndPassword(user);
    }

    /**
     * 验证用户名是否存在
     * @param user
     * @return
     */
    @Override
    public User findByUsername(User user) {
        return mapper.findByUsername(user.getUsername());
    }

    /**
     * 修改登陆密码：对email进行精确匹配，并修改Password
     * @param user
     * @return
     */
    @Override
    public boolean updatePassword(User user) {
        return mapper.updatePassword(user)>0;
    }

    /**
     * 修改个人信息
     * @param user
     * @return
     */
    @Override
    public boolean update(User user) {
        return mapper.update(user)>0;
    }

    /**
     * 注册新用户
     * @param user
     * @return
     */
    @Override
    public boolean register(User user) {
        //查询用户名是否已经存在
        if(findByUsername(user)!=null){
            return false;
        }
        return mapper.insert(user)>0;
    }

    /**
     * 注销账号
     * @param username
     * @return
     */
    @Override
    public boolean delete(String username) {
        return mapper.delete(username) > 0;
    }
}
