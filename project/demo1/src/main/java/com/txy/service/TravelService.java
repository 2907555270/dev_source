package com.txy.service;


import com.github.pagehelper.PageInfo;
import com.txy.config.TravelPage;
import com.txy.domain.Travel;


public interface TravelService {
    PageInfo<Travel> findAll(int currentPage, int pageSize);

    boolean save(Travel travel);

    boolean update(Travel travel);

    boolean delete(String _id);

    PageInfo<Travel> findConditions(TravelPage travelPage);
}
