package com.txy.dao.Impl;

import com.github.pagehelper.PageInfo;
import com.txy.config.TravelPage;
import com.txy.dao.TravelDao;
import com.txy.domain.Travel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


@Repository
public class TravelDaoImpl implements TravelDao {

    @Override
    public PageInfo<Travel> findAll(int currentPage, int pageSize) {
        Query query = new Query();
        //判断页数是否超出：若超出，则默认第一页
        long total = mongoTemplate.count(query, Travel.class,collection);
        if ((long) (currentPage - 1) * pageSize >= total)
            currentPage = 1;
        //分页查询
        query.with(PageRequest.of(currentPage - 1, pageSize));
        List<Travel> travels = mongoTemplate.find(query, Travel.class, collection);
        PageInfo<Travel> pageInfo = new PageInfo<>(travels);
        pageInfo.setTotal(total);
        return pageInfo;
    }

    @Autowired
    private MongoTemplate mongoTemplate;

    private final String collection = "travel";


    @Override
    public boolean save(Travel travel) {
        mongoTemplate.insert(travel, collection);
        return true;
    }

    @Override
    public boolean update(Travel travel) {
        Travel update = mongoTemplate.findAndReplace(Query.query(Criteria.where("_id").is(travel.get_id())), travel, collection);
        return update != null;
    }

    @Override
    public boolean delete(String _id) {
        Travel delete = mongoTemplate.findAndRemove(Query.query(Criteria.where("_id").is(_id)), Travel.class, collection);
        return delete != null;
    }

    @Override
    public PageInfo<Travel> findConditions(Travel travel, int currentPage, int pageSize) {
        Query query = new Query();
        //title正则表达式:忽略大小写
        ArrayList<Criteria> criteriaArrayList = new ArrayList<>();
        if (travel.getTitle() != null) {
            criteriaArrayList.add(Criteria.where("title").regex(Pattern.compile("^.*" + travel.getTitle() + ".*$")));
        }
        if (travel.getDescription() != null) {
            criteriaArrayList.add(Criteria.where("description").regex(Pattern.compile("^.*" + travel.getDescription() + ".*$")));
        }
        if (travel.getCategory() != null) {
            criteriaArrayList.add(Criteria.where("category").regex(Pattern.compile("^.*" + travel.getCategory() + ".*$")));
        }
        if (travel.getAuthor() != null) {
            criteriaArrayList.add(Criteria.where("author").regex(Pattern.compile("^.*" + travel.getAuthor() + ".*$")));
        }
        //若有条件 则组装查询条件
        if(criteriaArrayList.size()>0)
            query.addCriteria(new Criteria().andOperator(criteriaArrayList));
        long total = mongoTemplate.count(query, Travel.class,collection);

        //组装分页条件
        if ((long) (currentPage - 1) * pageSize >= total)
            currentPage = 1;
        Pageable pageable = PageRequest.of(currentPage-1, pageSize);
        query.with(pageable);

        List<Travel> travels = mongoTemplate.find(query, Travel.class, collection);

        //查询结果
        PageInfo<Travel> pageInfo = new PageInfo<>(travels);
        pageInfo.setTotal(total);
        return pageInfo;
    }
}
