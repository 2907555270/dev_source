package service;

import com.txy.domain.Admin;
import com.txy.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void test_login(){
        Admin admin1 = adminService.login("test","test");
        System.out.println(admin1);
    }

    @Test
    public void test_update(){
        Admin admin = new Admin();
        admin.setUsername("test");
        admin.setPassword("test");
        boolean flag = adminService.update(admin);
        System.out.println(flag);
    }
}
