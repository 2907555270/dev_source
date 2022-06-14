package com.example.demo1_boot.dao;

import com.example.demo1_boot.domain.Travel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TravelDaoTest {

    @Autowired
    private TravelDao travelDao;

    @Test
    public void test1(){
        List<Travel> list = travelDao.findAll();
        System.out.println(list.toString());
    }
}
