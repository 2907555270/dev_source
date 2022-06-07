package com.txy.service;

import com.txy.domain.User;

public interface UserService {
    User login(User user);

    boolean update(User user);

    boolean register(User user);
}
