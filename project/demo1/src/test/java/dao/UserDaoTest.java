package dao;

import com.txy.mapper.UserMapper;
import com.txy.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class UserDaoTest {
    @Autowired
    private UserMapper mapper;

    private User user;

    @Before
    public void before() {
        user = new User(null, "test", "test", "test", 10, "test", "123", "2907@qq.com", "/home/pic.img", 0);
    }

    @Test
    public void test_insert(){
        int insert = mapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void test_findByUsername(){
        System.out.println(mapper.findByUsername(user));
    }

    @Test
    public void test_findByUsernameAndPassword() {
        User user1 = mapper.findByUsernameAndPassword(user);
        System.out.println(user1.toString());
    }

    @Test
    public void test_update(){
        user.setUid(1);
        user.setAge(20);
        int update = mapper.update(user);
        System.out.println(update);
    }
}
