package service;

import com.txy.domain.Goods;
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
    public void test_findAll(){
        List<Goods> goods = service.findByCategory(2);
        System.out.println(goods.toString());
    }
}
