package com.txy.service;


import java.util.List;

public interface GoodsService {
    List<Object> findByCategory(int category);

    List<String> findByName(String name);
}
