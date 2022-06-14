package com.txy.service;

import com.txy.domain.Admin;

public interface AdminService {
    Admin login(String username,String password);

    boolean update(Admin admin);
}
