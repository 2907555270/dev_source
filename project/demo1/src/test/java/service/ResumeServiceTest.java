package service;

import com.github.pagehelper.PageInfo;
import com.txy.config.ResumePage;
import com.txy.dao.ResumeDao;
import com.txy.domain.Resume;
import com.txy.domain.User;
import com.txy.service.ResumeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ResumeServiceTest {

    @Autowired
    private ResumeService resumeService;

    @Test
    public void test_findByConditions(){
        Resume resume = new Resume();
        User user = new User();
        //user.setUsername("zhangsan");
        //resume.setUser(user);
        ResumePage resumePage = new ResumePage(resume,1,1);
        PageInfo<Resume> pageInfo = resumeService.findByConditions(resumePage);
        System.out.println(pageInfo);
    }
}
