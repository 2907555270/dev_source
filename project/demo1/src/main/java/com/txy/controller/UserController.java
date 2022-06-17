package com.txy.controller;

import com.txy.config.Result;
import com.txy.config.UserPage;
import com.txy.domain.User;
import com.txy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     *  查询所有用户信息：必须携带分页信息才能访问
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/findAll")
    public Result findAll(int currentPage, int pageSize){
        return new Result(true,userService.findAll(currentPage,pageSize));
    }

    /**
     * 登录：使用Get方式，就不用@RequestBody
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public Result login(String username,String password,HttpServletRequest request){
        User login = userService.login(username,password);
        if(login==null)
            return new Result(false,"用户名或密码错误 -_-");
        else{
            //登录成功，保存登录信息
            request.getSession().setAttribute("user",login);
        }
        return new Result(true,"登录成功 ^_^",login);
    }

    @GetMapping("userInfo")
    public Result getUserInfo(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        boolean flag = user!=null;
        return new Result(flag,flag?"用户信息获取成功":"请先登录",user);
    }

    @GetMapping("logOut")
    public Result logOut(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return new Result(true,"您已退出登录");
    }

    /**
     * 多条件查询用户信息：user + page
     * @param userPage
     * @return
     */
    @PostMapping("select")
    public Result findByConditions(@RequestBody UserPage userPage){
        return new Result(true,userService.findByConditions(userPage.getUser(),userPage.getCurrentPage(), userPage.getPageSize()));
    }

    /**
     * 新增用户信息
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        if(userService.register(user)){
            return new Result(true,"注册成功 ^_^");
        }
        return new Result(false,"当前用户名已存在 -_-");
    }

    /**
     * 修改用户信息：按照username匹配唯一用户
     * @param user
     * @return
     */
    @PutMapping("/update_pwd")
    public Result updatePassword(@RequestBody User user){
        boolean flag = userService.updatePassword(user);
        return new Result(flag,flag?"修改成功 ^_^":"个人信息匹配错误，修改失败 -_-");
    }


    /**
     * 更新用户信息：按照username匹配唯一用户
     * @param user
     * @return
     */
    @PutMapping("update")
    public Result update(@RequestBody User user){
        boolean flag = userService.update(user);
        return new Result(flag,flag?"修改成功 ^_^":"修改失败 -_-");
    }

    /**
     * 删除用户信息：按照username匹配唯一用户
     * @param user
     * @return
     */
    @DeleteMapping("delete")
    public Result delete(@RequestBody User user){
        boolean flag = userService.delete(user.getUsername());
        return new Result(flag,flag?"删除成功 ^_^":"删除失败 -_-");
    }
}
