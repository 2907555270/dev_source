package com.txy.mapper;

import com.txy.domain.Admin;

public interface AdminMapper {
    //根据用户名和密码查询
    Admin findByUsernameAndPassword(Admin admin);

    int update(Admin admin);
}
