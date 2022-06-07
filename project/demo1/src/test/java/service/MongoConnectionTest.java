package service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MongoConnectionTest {

    @Autowired
    private MongoDatabase mongoDatabase;


    @Test
    public void test(){
        FindIterable<Document> documents = mongoDatabase.getCollection("goods").find(Filters.eq("name","a"));
        String s = documents.iterator().next().toJson();
        System.out.println(s);
    }

}
