package com.txy.dao.Impl;

import com.alibaba.fastjson.JSON;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.txy.dao.GoodsDao;
import com.txy.domain.Goods;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    private MongoCollection<Document> collection;

    @Override
    public List<Object> findByCategory(int category) {
        ArrayList<Object> objects = new ArrayList<>();
        //查询文档
        FindIterable<Document> documents = collection.find(Filters.eq("category", category));
        //文档拆分转换为json
        for (Document document : documents) {
            objects.add(JSON.parse(document.toJson()));
        }
        return objects;
    }

    @Override
    public List<String> findByName(String name) {
        ArrayList<String> jsons = new ArrayList<>();

        FindIterable<Document> documents = collection.find(Filters.eq("name", name));
        for(Document document:documents){
            jsons.add(document.toJson());
        }
        return jsons;
    }


    @Override
    public boolean save(Goods goods) {
        String json = null;
        if(goods!=null){
            json = JSON.toJSONString(goods);
        }
        collection.insertOne(Document.parse(json));
        return true;
    }

    @Override
    public boolean update(Goods goods) {
        Document document = collection.findOneAndReplace(Filters.eq("gid", goods.getGid()),
                Document.parse(JSON.toJSONString(goods)));
        return document != null;
    }

    @Override
    public boolean delete(Goods goods) {
        Document document = collection.findOneAndDelete(Filters.eq("gid", goods.getGid()));
        return document!=null;
    }
}
