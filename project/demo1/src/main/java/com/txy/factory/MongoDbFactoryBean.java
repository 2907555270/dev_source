package com.txy.factory;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import lombok.Setter;

@Setter
public class MongoDbFactoryBean {

    private String dbName;
    private MongoClient mongoClient;

    public MongoDatabase getMongoDatabase() {
        return mongoClient.getDatabase(dbName);
    }
}
