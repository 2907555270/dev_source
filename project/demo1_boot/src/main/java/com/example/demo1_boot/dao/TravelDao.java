package com.example.demo1_boot.dao;

import com.example.demo1_boot.domain.Travel;

import java.util.List;

public interface TravelDao {
    List<Travel> findAll();
}
