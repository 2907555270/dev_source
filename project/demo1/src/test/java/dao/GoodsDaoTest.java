package dao;

import com.txy.dao.GoodsDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GoodsDaoTest {

    @Autowired
    private GoodsDao goodsDao;

    //@Test
    //public void test_findByCategory(){
    //    //List<Goods> goods = goodsDao.findByCategory(1);
    //}

    @Test
    public void test_findByName(){
        String a = goodsDao.findByName("a");
        System.out.println(a);
    }
}
