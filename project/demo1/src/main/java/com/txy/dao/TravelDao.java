package com.txy.dao;


import com.github.pagehelper.PageInfo;
import com.txy.config.TravelPage;
import com.txy.domain.Travel;

import java.util.List;


public interface TravelDao {

    PageInfo<Travel> findAll(int currentPage, int pageSize);

    boolean save(Travel travel);

    boolean update(Travel travel);

    boolean delete(String _id);

    PageInfo<Travel> findConditions(Travel travel,int currentPage,int pageSize);

}
