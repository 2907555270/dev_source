package com.txy.dao.Impl;

import com.txy.dao.GoodsDao;
import com.txy.domain.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDaoImpl implements GoodsDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Goods> findByCategory(int category) {
        List<Goods> goods = mongoTemplate.findAll(Goods.class);
        return goods;
    }
}
