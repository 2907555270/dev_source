package com.txy.controller;

import com.txy.config.Result;
import com.txy.domain.User;
import com.txy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    private Result R;

    @GetMapping
    public Result login(@RequestBody User user){
        User login = userService.login(user);
        if(login==null)
            return new Result(false,"登录失败-_-");
        return new Result(true,"登录成功^_^",login);
    }

    @PostMapping
    public Result register(@RequestBody User user){
        if(userService.register(user)){
            return new Result(true,"注册成功^_^");
        }
        return new Result(false,"当前用户名已存在-_-");
    }

    @PutMapping
    public Result update(@RequestBody User user){
        boolean flag = userService.update(user);
        return new Result(flag,flag?"修改成功^_^":"修改失败-_-");
    }
}
