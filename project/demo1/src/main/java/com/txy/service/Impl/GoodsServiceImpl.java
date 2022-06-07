package com.txy.service.Impl;

import com.txy.domain.Goods;
import com.txy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private MongoTemplate template;

    @Override
    public List<Goods> findByCategory(int category) {
        List<Goods> goods = template.findAll(Goods.class);
        return goods;
    }
}
