package com.txy.dao;

import com.txy.domain.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> findByCategory(int category);
}
