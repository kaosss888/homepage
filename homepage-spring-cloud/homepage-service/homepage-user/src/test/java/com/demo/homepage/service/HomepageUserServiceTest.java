package com.demo.homepage.service;

import com.alibaba.fastjson.JSON;
import com.demo.homepage.Application;
import com.demo.homepage.dao.HomepageUserCourseDao;
import com.demo.homepage.entity.HomepageUserCourse;
import com.demo.homepage.vo.CreateUserRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class HomepageUserServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private HomepageUserCourseDao userCourseDao;

    @Test
    public void testCreateUser() {
        System.out.println(JSON.toJSON(userService.createUser(
                new CreateUserRequest("username", "username@mail.com")
        )));
    }

    @Test
    public void testGetUserInfo() {
        System.out.println(JSON.toJSONString(userService.getUserInfo(3L)));
    }

    @Test
    public void testCreateHomepageUserCourse() {
        HomepageUserCourse course1 = new HomepageUserCourse();
        course1.setUserId(3L);
        course1.setCourseId(1L);

        HomepageUserCourse course2 = new HomepageUserCourse();
        course2.setUserId(3L);
        course2.setCourseId(2L);

        System.out.println(userCourseDao.saveAll(Arrays.asList(course1, course2)));
    }
}
