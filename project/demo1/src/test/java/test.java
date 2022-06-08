//import com.alibaba.fastjson.JSON;
//import com.mongodb.client.MongoCollection;
//import com.txy.domain.Goods;
//import org.bson.Document;
//import org.junit.Test;
//
//public class test {
//    private MongoCollection collection;
//    @Test
//    public void test1(){
//        Goods goods = new Goods("zhangsan",10,"zhangsan",30.0,"zhangsan","/home/pinc/",0);
//        String json = JSON.toJSONString(goods);
//        Document document = Document.parse(json);
//        collection.insertOne(document);
//        System.out.println(json);
//    }
//}
