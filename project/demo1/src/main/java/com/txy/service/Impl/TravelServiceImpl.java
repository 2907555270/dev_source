package com.txy.service.Impl;

import com.github.pagehelper.PageInfo;
import com.txy.config.TravelPage;
import com.txy.dao.TravelDao;
import com.txy.domain.Travel;
import com.txy.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelDao travelDao;

    @Override
    public PageInfo<Travel> findAll(int currentPage, int pageSize) {
        return travelDao.findAll(currentPage,pageSize);
    }

    @Override
    public PageInfo<Travel> findConditions(TravelPage travelPage) {
        return travelDao.findConditions(travelPage.getTravel(),travelPage.getCurrentPage(),travelPage.getPageSize());
    }

    @Override
    public boolean save(Travel travel) {
        return travelDao.save(travel);
    }

    @Override
    public boolean update(Travel travel) {
        return travelDao.update(travel);
    }

    @Override
    public boolean delete(String _id) {
        return travelDao.delete(_id);
    }



}
