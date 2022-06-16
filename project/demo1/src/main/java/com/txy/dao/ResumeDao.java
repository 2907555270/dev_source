package com.txy.dao;

import com.github.pagehelper.PageInfo;
import com.txy.domain.Resume;

public interface ResumeDao {
    boolean save(Resume resume);

    PageInfo<Resume> findAll(int currentPage, int pageSize);

    PageInfo<Resume> findByConditions(Resume resume,int currentPage,int pageSize);

    boolean update(Resume resume);

    boolean delete(String _id);
}
