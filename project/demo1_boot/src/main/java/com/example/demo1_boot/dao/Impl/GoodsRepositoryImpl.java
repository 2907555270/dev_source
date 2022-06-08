package com.example.demo1_boot.dao.Impl;

import com.example.demo1_boot.dao.GoodsRepository;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


@Repository
public class GoodsRepositoryImpl implements GoodsRepository {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public String findByName(String name) {
        FindIterable<Document> documents = mongoTemplate.getCollection("goods").find(Filters.eq("name", name));
        //FindIterable<Document> documents = collection.find(Filters.eq("name", name));
        String s = documents.iterator().next().toJson();
        return s;
    }
}
