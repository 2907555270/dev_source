package dao;

import com.github.pagehelper.PageInfo;
import com.txy.dao.ResumeDao;
import com.txy.domain.Resume;
import com.txy.domain.User;
import com.txy.domain.resume.EducationInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ResumeDaoTest {

    @Autowired
    private ResumeDao resumeDao;

    @Test
    public void test_findAll(){
        PageInfo<Resume> pageInfo = resumeDao.findAll(2, 5);
        System.out.println(pageInfo);
    }

    @Test
    public void test_findByConditions(){
        Resume resume = new Resume();
        User user = new User();
        user.setUsername("zhangsan");
        EducationInfo educationInfo = new EducationInfo();
        educationInfo.setSchool("学校");
        resume.setUser(user);
        resume.setEducationInfo(educationInfo);
        PageInfo<Resume> pageInfo = resumeDao.findByConditions(resume, 1, 1);
        System.out.println(pageInfo);
    }
}
