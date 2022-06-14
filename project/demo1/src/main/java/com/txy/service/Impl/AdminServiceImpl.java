package com.txy.service.Impl;

import com.txy.domain.Admin;
import com.txy.mapper.AdminMapper;
import com.txy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper mapper;

    @Override
    public Admin login(String username,String password) {
        Admin admin = new Admin();
        if(username!=null&&password!=null){
            admin.setUsername(username);
            admin.setPassword(password);
        }
        return mapper.findByUsernameAndPassword(admin);
    }

    @Override
    public boolean update(Admin admin) {
        return mapper.update(admin)>0;
    }
}
