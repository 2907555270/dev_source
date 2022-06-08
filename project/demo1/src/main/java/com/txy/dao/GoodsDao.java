package com.txy.dao;

import com.txy.domain.Goods;

import java.util.List;


public interface GoodsDao {
    List<Object> findByCategory(int category);

    List<String> findByName(String name);

    boolean save(Goods goods);

    boolean update(Goods goods);

    boolean delete(Goods goods);


}
