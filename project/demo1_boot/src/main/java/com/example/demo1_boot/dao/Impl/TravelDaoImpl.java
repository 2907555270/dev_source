package com.example.demo1_boot.dao.Impl;

import com.example.demo1_boot.dao.TravelDao;
import com.example.demo1_boot.domain.Travel;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;


@Repository
public class TravelDaoImpl implements TravelDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public List<Travel> findAll() {
        return mongoTemplate.findAll(Travel.class, "travel");
    }
}
