package com.example.demo1_boot.controller;

import com.example.demo1_boot.dao.TravelDao;
import com.example.demo1_boot.domain.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("travel")
public class TravelController {
    @Autowired
    private TravelDao travelDao;

    @GetMapping()
    public List<Travel> findAll(){
        return travelDao.findAll();
    }
}
