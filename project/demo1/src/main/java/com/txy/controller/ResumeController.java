package com.txy.controller;

import com.github.pagehelper.PageInfo;
import com.txy.config.Result;
import com.txy.config.ResumePage;
import com.txy.domain.Resume;
import com.txy.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("resume")
//@CrossOrigin(origins = "*",maxAge = 3600)
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    /**
     * 查询所有的简历信息--分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("findAll")
    public Result findAll(int currentPage,int pageSize){
        return new Result(true,resumeService.findAll(currentPage,pageSize));
    }

    /**
     * 多条件模糊查询简历信息--分页查询
     * @param resumePage
     * @return
     */
    @PostMapping("select")
    public Result findByConditions(@RequestBody ResumePage resumePage){
        System.out.println(resumePage);
        PageInfo<Resume> pageInfo = resumeService.findByConditions(resumePage);
        boolean flag = pageInfo.getList().size()>0;
        return new Result(flag,flag?"查询成功 ^_^":"查询结果为空 -_-",pageInfo);
    }

    /**
     * 保存用户的简历信息
     * @param resume
     * @return
     */
    @PostMapping("save")
    public Result save(@RequestBody Resume resume){
        boolean flag = resumeService.save(resume);
        return new Result(flag,flag?"保存成功 ^_^":"保存失败 -_-");
    }

    /**
     * 生成简历过程中，临时将数据保存在Session
     * @param resume
     * @param request
     * @return
     */
    @PostMapping("upload")
    public Result uploadResume(@RequestBody Resume resume, HttpServletRequest request){
        request.getSession().setAttribute("resume",resume);
        if(resume==null)
            return new Result(false,"空简历信息 -_-");
        else{
            return new Result(true,"简历信息提交成功 ^_^");
        }
    }

    /**
     * 用户获取临时放置在Session中的简历信息
     * @param request
     * @return
     */
    @GetMapping("getResume")
    public Result getResume(HttpServletRequest request){
        Resume resume = (Resume) request.getSession().getAttribute("resume");
        boolean flag = resume!=null;
        return new Result(flag,flag?"简历信息获取成功 ^_^":"空简历信息 -_-",resume);
    }

    /**
     * 更新指定的简历信息--按Mongodb _id匹配
     * @param resume
     * @return
     */
    @PutMapping("update")
    public Result update(@RequestBody Resume resume){
        boolean flag = resumeService.update(resume);
        return new Result(flag,flag?"修改成功 ^_^":"修改失败 -_-");
    }

    /**
     * 删除指定的简历信息--按Mongodb _id匹配
     * @param resume
     * @return
     */
    @DeleteMapping("delete")
    public Result delete(@RequestBody Resume resume){
        boolean flag = resumeService.delete(resume);
        return new Result(flag,flag?"删除成功 ^_^":"删除失败 -_-");
    }
}
