package com.txy.service.Impl;

import com.github.pagehelper.PageInfo;
import com.txy.config.ResumePage;
import com.txy.dao.ResumeDao;
import com.txy.domain.Resume;
import com.txy.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Override
    public PageInfo<Resume> findAll(int currentPage, int pageSize) {
        return resumeDao.findAll(currentPage,pageSize);
    }

    @Override
    public PageInfo<Resume> findByConditions(ResumePage resumePage) {
       return resumeDao.findByConditions(resumePage.getResume(),resumePage.getCurrentPage(),resumePage.getPageSize());
    }

    @Override
    public boolean save(Resume resume) {
        return resumeDao.save(resume);
    }

    @Override
    public boolean update(Resume resume) {
        return resumeDao.update(resume);
    }

    @Override
    public boolean delete(Resume resume) {
        return resumeDao.delete(resume.get_id());
    }
}
