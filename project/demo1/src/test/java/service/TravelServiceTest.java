package service;

import com.github.pagehelper.PageInfo;
import com.txy.domain.Travel;
import com.txy.service.TravelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TravelServiceTest {

    @Autowired
    TravelService service;

    @Test
    public void test_findAll(){
        PageInfo<Travel> pageInfo = service.findAll(1,1);
        System.out.println(pageInfo);
    }

    @Test
    public void test_save(){
    }

    @Test
    public void test_update(){
    }

    @Test
    public void test_delete(){
    }
}
