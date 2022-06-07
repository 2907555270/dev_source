package com.txy.service.Impl;

import com.txy.dao.GoodsDao;
import com.txy.domain.Goods;
import com.txy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public List<Goods> findByCategory(int category) {
        //List<Goods> goods = goodsDao.findByCategory(category);
        //return goods;
        return null;
    }

    @Override
    public String findByName(String name) {
        return goodsDao.findByName(name);
    }
}
