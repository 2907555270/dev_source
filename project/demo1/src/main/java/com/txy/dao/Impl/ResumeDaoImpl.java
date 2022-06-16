package com.txy.dao.Impl;

import com.github.pagehelper.PageInfo;
import com.txy.dao.ResumeDao;
import com.txy.domain.Resume;
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
public class ResumeDaoImpl implements ResumeDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    private final String collectionName = "resume";

    @Override
    public PageInfo<Resume> findAll(int currentPage, int pageSize) {
        Query query = new Query();
        //判断页数是否超出：若超出，则默认第一页
        long total = mongoTemplate.count(query, Resume.class,collectionName);
        if ((long) (currentPage - 1) * pageSize >= total)
            currentPage = 1;
        ////分页查询
        query.with(PageRequest.of(currentPage - 1, pageSize));
        List<Resume> resumes = mongoTemplate.find(query, Resume.class, collectionName);
        PageInfo<Resume> pageInfo = new PageInfo<>(resumes);
        pageInfo.setTotal(total);
        return pageInfo;
    }

    @Override
    public PageInfo<Resume> findByConditions(Resume resume, int currentPage, int pageSize) {
        //创建查询条件
        Query query = new Query();
        ArrayList<Criteria> criteriaArrayList = new ArrayList<>();
        if (resume!=null){
            //按username查
            if (resume.getUser()!=null&&resume.getUser().getUsername() != null) {
                criteriaArrayList.add(Criteria.where("user.username").regex(Pattern.compile("^.*" + resume.getUser().getUsername() + ".*$")));
            }
            //按求职意向查
            if (resume.getBasicInfo()!=null&&resume.getBasicInfo().getJob_profile() != null) {
                criteriaArrayList.add(Criteria.where("basicInfo.job_profile").regex(Pattern.compile("^.*" + resume.getBasicInfo().getJob_profile() + ".*$")));
            }
            //按学校查
            if (resume.getEducationInfo()!=null&&resume.getEducationInfo().getSchool() != null) {
                criteriaArrayList.add(Criteria.where("educationInfo.school").regex(Pattern.compile("^.*" + resume.getEducationInfo().getSchool() + ".*$")));
            }
            //按学历查
            if (resume.getEducationInfo()!=null&&resume.getEducationInfo().getLearning_record() != null) {
                criteriaArrayList.add(Criteria.where("educationInfo.learning_record").regex(Pattern.compile("^.*" + resume.getEducationInfo().getLearning_record() + ".*$")));
            }
        }

        //若有查询条件，则组装查询条件
        if(criteriaArrayList.size()>0)
            query.addCriteria(new Criteria().andOperator(criteriaArrayList));
        long total = mongoTemplate.count(query, Resume.class,collectionName);

        //组装分页条件
        if ((long) (currentPage - 1) * pageSize >= total)
            currentPage = 1;
        Pageable pageable = PageRequest.of(currentPage-1, pageSize);
        query.with(pageable);

        List<Resume> resumes = mongoTemplate.find(query, Resume.class, collectionName);

        //查询结果
        PageInfo<Resume> pageInfo = new PageInfo<>(resumes);
        pageInfo.setTotal(total);
        return pageInfo;

    }

    @Override
    public boolean update(Resume resume) {
        mongoTemplate.findAndReplace(Query.query(Criteria.where("_id").is(resume.get_id())),resume,collectionName);
        return true;
    }

    @Override
    public boolean delete(String _id) {
        mongoTemplate.findAndRemove(Query.query(Criteria.where("_id").is(_id)),Resume.class,collectionName);
        return true;
    }


    @Override
    public boolean save(Resume resume) {
        mongoTemplate.save(resume,collectionName);
        return true;
    }


}
