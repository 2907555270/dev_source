package service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.txy.domain.User;
import com.txy.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private User user;

    @Before
    public void before() {
        user = new User(null, "test_a", "test123", "test", 10, "test", "123", "2907@qq.com", "/home/pic.img");
    }


    @Test
    public void test_findAll(){
        PageInfo<User> pageInfo = userService.findAll(1, 1);
        System.out.println(pageInfo);
    }

    @Test
    public void test_findByConditions(){
        PageInfo<User> pageInfo = userService.findByConditions(null, 1, 1);
        System.out.println(pageInfo);
    }

    @Test
    public void test_login(){
        User login = userService.login("test","test");
        if(login!=null){
            System.out.println(login.toString());
        }
    }

    @Test
    public void test_register(){
        boolean register = userService.register(user);
        System.out.println(register);
    }

    @Test
    public void test_update(){
        User user = new User();
        user.setUid(13);
        user.setAge(30);
        System.out.println(userService.update(user));
    }
}
