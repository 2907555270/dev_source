package dao;

import com.github.pagehelper.PageInfo;
import com.txy.config.TravelPage;
import com.txy.dao.TravelDao;
import com.txy.domain.Travel;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TravelDaoTest {

    @Autowired
    private TravelDao travelDao;

    @Autowired
    private MongoTemplate mongoTemplate;

    private Travel travel;

    @Before
    public void before(){
        travel = new Travel(null,"自然之道", "Description","zhangsan",
                "https://fuss10.elemecdn.com/9/bb/e27858e973f5d7d3904835f46abbdjpeg.jpeg","動物");
    }

    //测试spring容器是否加载了mongoTemplate
    @Test
    public void test(){
        System.out.println(mongoTemplate);
    }

    @Test
    public void test_save(){
        boolean save = travelDao.save(travel);
        System.out.println(save);
    }

    //可通过_id转换为String去匹配索引查询
    @Test
    public void test_findBy_id(){
        List<Travel> travels = mongoTemplate.find(Query.query(Criteria.where("_id").is("62a6dcd91dea241bbb9b424c")), Travel.class, "travel");
        System.out.println(travels);
    }

    @Test
    public void test_findAll(){
        PageInfo<Travel> pageInfo = travelDao.findAll(1, 3);
        System.out.println(pageInfo);
    }

    @Test
    public void test_findConditions(){
        Travel travel = new Travel();
        travel.setTitle("自然之道");
        PageInfo<Travel> pageInfo = travelDao.findConditions(travel, 1, 3);
        System.out.println(pageInfo);
    }

    //@Test
    //public void test_update(){
    //    Travel travel = travelDao.findConditions("動物").get(0);
    //    System.out.println(travel.get_id());
    //    travel.setTitle("修改2");
    //    boolean update = travelDao.update(travel);
    //    System.out.println(update);
    //}
    //
    //@Test
    //public void test_delete(){
    //    Travel travel = travelDao.findByCategory("動物").get(0);
    //    boolean delete = travelDao.delete(travel.get_id());
    //    System.out.println(delete);
    //}
}
