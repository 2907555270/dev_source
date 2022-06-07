package com.txy.dao;

import com.txy.domain.Goods;


public interface GoodsDao {
    String[] findByCategory(int category);

    String findByName(String name);

    boolean save(Goods goods);

    boolean update(Goods goods);

    boolean delete(Goods goods);


}
