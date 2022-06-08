package dao;

import com.txy.dao.GoodsDao;
import com.txy.domain.Goods;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GoodsDaoTest {

    @Autowired
    private GoodsDao goodsDao;

    private Goods goods;

    @Before
    public void before(){
        goods = new Goods(null,2,"test",20,"世界浙大",
                "home/pic.png",1);
    }

    @Test
    public void test_findByCategory(){
        List<Object> jsons = goodsDao.findByCategory(1);
        System.out.println(jsons);
    }

    @Test
    public void test_findByName(){
        List<String> jsons = goodsDao.findByName("test");
        System.out.println(jsons);
    }

    @Test
    public void test_save(){
        boolean save = goodsDao.save(goods);
        System.out.println(save);
    }

    @Test
    public void test_update(){
        goods.setPrice(100);
        boolean update = goodsDao.update(goods);
        System.out.println(update);
    }

    @Test
    public void test_delete(){
        boolean delete = goodsDao.delete(goods);
        System.out.println(delete);
    }
}
