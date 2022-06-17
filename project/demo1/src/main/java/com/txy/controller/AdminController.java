package com.txy.controller;

import com.txy.config.Result;
import com.txy.domain.Admin;
import com.txy.domain.User;
import com.txy.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("login")
    public Result login(String username,String password, HttpServletRequest request){
        Admin login = adminService.login(username,password);
        boolean flag = login!=null;
        //登录信息存入Session
        if(flag){
            request.getSession().setAttribute("user",login);
        }
        return new Result(flag,flag?"登录成功 ^_^":"用户名或密码错误 -_-",login);
    }

    @PutMapping("update")
    public Result update(@RequestBody Admin admin){
        boolean flag = adminService.update(admin);
        return new Result(flag,flag?"修改成功 ^_^":"修改失败 -_-");
    }

    @GetMapping("isLogin")
    public Result isLogin(HttpServletRequest request){
        Admin admin = (Admin) request.getSession().getAttribute("user");
        boolean flag = admin!= null;
        return new Result(flag,admin);
    }

    @GetMapping("logOut")
    public void logOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
    }
}
