package com.txy.controller;

import com.txy.config.Result;
import com.txy.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping()
    public Result findByName(@RequestParam("name") String name){
        return new Result(true,goodsService.findByName(name));
    }

    @GetMapping("/{category}")
    public Result findByCategory(@PathVariable int category){
        return new Result(true,goodsService.findByCategory(category));
    }


}
