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
        user = new User(null, "test", "test", "test", 10, "test", "123", "2907@qq.com", "/home/pic.img");
    }

    @Test
    public void test_findAll(){
        System.out.println(mapper.findAll());
    }

    @Test
    public void test_findByConditions(){
        User u1 = new User();
        u1.setUsername("t");
        System.out.println(mapper.findByConditions(u1));
    }


    @Test
    public void test_updatePassword(){
        user.setPassword("123456");
        mapper.updatePassword(user);
    }

    @Test
    public void test_insert(){
        int insert = mapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void test_update(){
        user.setUid(1);
        user.setAge(20);
        int update = mapper.update(user);
        System.out.println(update);
    }

    public void test_delete(){
        mapper.delete("aa");
    }
}
