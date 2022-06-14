package dao;

import com.txy.domain.Admin;
import com.txy.mapper.AdminMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminDaoTest {

    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void test_updatePassword(){
        Admin admin = new Admin();
        admin.setUsername("test");
        admin.setPassword("update");
        adminMapper.update(admin);
    }
}
