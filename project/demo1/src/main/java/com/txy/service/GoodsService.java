package com.txy.service;

import com.txy.domain.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> findByCategory(int category);
}
