package service;

import com.txy.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GoodsServiceTest {

    @Autowired
    GoodsService service;

    @Test
    public void test_findByCategory(){
        List<Object> goods = service.findByCategory(1);
        System.out.println(goods.toString());
    }

    @Test
    public void test_findByName(){
        List<String> goods = service.findByName("a");
        System.out.println(goods);
    }
}
