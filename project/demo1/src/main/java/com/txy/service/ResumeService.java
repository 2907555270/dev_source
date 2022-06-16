package com.txy.service;

import com.github.pagehelper.PageInfo;
import com.txy.config.ResumePage;
import com.txy.domain.Resume;

public interface ResumeService {
    boolean save(Resume resume);

    PageInfo<Resume> findAll(int currentPage, int pageSize);

    PageInfo<Resume> findByConditions(ResumePage resumePage);

    boolean update(Resume resume);

    boolean delete(Resume resume);
}
