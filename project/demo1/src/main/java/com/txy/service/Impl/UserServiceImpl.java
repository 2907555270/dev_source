package com.txy.service.Impl;

import com.txy.mapper.UserMapper;
import com.txy.domain.User;
import com.txy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User login(User user) {
        return mapper.findByUsernameAndPassword(user);
    }

    @Override
    public boolean update(User user) {
        return mapper.update(user)>0;
    }

    @Override
    public boolean register(User user) {
        if(mapper.findByUsername(user)!=null){
            return false;
        }
        return mapper.insert(user)>0;
    }
}
