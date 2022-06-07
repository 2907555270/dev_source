package service;

import com.txy.domain.User;
import com.txy.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    private User user;

    @Before
    public void before() {
        user = new User(null, "test", "test", "test", 10, "test", "123", "2907@qq.com", "/home/pic.img", 0);
    }

    @Test
    public void test_login(){
        User login = userService.login(user);
        System.out.println(login.toString());
    }

    @Test
    public void test_register(){
        boolean register = userService.register(user);
        System.out.println(register);
    }

    @Test
    public void test_update(){
        User user = new User();
        user.setUid(6);
        user.setAge(30);
        System.out.println(userService.update(user));
    }
}
