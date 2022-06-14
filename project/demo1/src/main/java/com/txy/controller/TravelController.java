package com.txy.controller;

import com.github.pagehelper.PageInfo;
import com.txy.config.Result;
import com.txy.config.TravelPage;
import com.txy.domain.Travel;
import com.txy.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/travel")
public class TravelController {
    @Autowired
    private TravelService travelService;

    @GetMapping("/findAll")
    public Result findAll(int currentPage,int pageSize){
        return new Result(true,travelService.findAll(currentPage,pageSize));
    }

    @PostMapping("/select")
    public Result findConditions(@RequestBody TravelPage travelPage){
        System.out.println(travelPage);
        PageInfo<Travel> pageInfo = travelService.findConditions(travelPage);
        boolean flag = pageInfo.getList().size()>0;
        return new Result(flag,flag?"查询成功 ^_^":"查询结果为空 -_-",pageInfo);
    }

    @PutMapping()
    public Result save(@RequestBody Travel travel){
        boolean flag = travelService.save(travel);
        return new Result(flag,flag?"添加成功^_^":"添加失败-_-");
    }

    @PostMapping()
    public Result update(@RequestBody Travel travel){
        boolean flag = travelService.update(travel);
        System.out.println(travel.toString());
        return new Result(flag,flag?"修改成功^_^":"修改失败-_-");
    }

    @DeleteMapping
    public Result delete(@RequestBody Travel travel){
        boolean flag = travelService.delete(travel.get_id());
        return new Result(flag,flag?"删除成功^_^":"删除失败-_-");
    }
}
