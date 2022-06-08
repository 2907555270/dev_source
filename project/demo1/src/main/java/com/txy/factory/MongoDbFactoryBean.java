package com.txy.factory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import lombok.Setter;
import org.bson.Document;

@Setter
public class MongoDbFactoryBean {

    private String dbName;
    private MongoClient mongoClient;

    public MongoCollection<Document> getMongoCollection(String cname){
        return mongoClient.getDatabase(dbName).getCollection(cname);
    }
}
