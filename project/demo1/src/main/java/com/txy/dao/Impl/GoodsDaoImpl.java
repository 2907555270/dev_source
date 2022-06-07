package com.txy.dao.Impl;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.txy.dao.GoodsDao;
import com.txy.domain.Goods;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    private MongoDatabase mongoDatabase;

    //private final MongoCollection<Document> collection = mongoTemplate.getCollection("goods");

    @Override
    public String[] findByCategory(int category) {
        //查找文档
        //FindIterable<Document> documents = collection.find(Filters.eq("category", category));
        //documents.
        return null;
    }

    @Override
    public String findByName(String name) {
        FindIterable<Document> documents = mongoDatabase.getCollection("goods").find(Filters.eq("name", name));
        return documents.iterator().next().toJson();
    }


    @Override
    public boolean save(Goods goods) {
        return false;
    }

    @Override
    public boolean update(Goods goods) {
        return false;
    }

    @Override
    public boolean delete(Goods goods) {
        return false;
    }
}
