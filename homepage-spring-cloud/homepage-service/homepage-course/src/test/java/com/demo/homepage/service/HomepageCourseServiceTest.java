package com.demo.homepage.service;

import com.alibaba.fastjson.JSON;
import com.demo.homepage.Application;
import com.demo.homepage.CourseInfosRequest;
import com.demo.homepage.dao.HomepageCourseDao;
import com.demo.homepage.entity.HomepageCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

/**
 * <h1>课程服务测试</h1>
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class}, webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class HomepageCourseServiceTest {

    @Autowired
    private HomepageCourseDao courseDao;

    @Autowired
    private ICourseService courseService;

    @Test
    public void testCreateCourseInfo() {

        HomepageCourse course1 = new HomepageCourse(
                "course1",
                0,
                "https://course1.com",
                "introduction111"
        );

        HomepageCourse course2 = new HomepageCourse(
                "course2",
                1,
                "https://course2.com",
                "introduction222"
        );

        courseDao.saveAll(Arrays.asList(course1, course2));
    }

    @Test
    public void testGetCourseInfo() {

        System.out.println(JSON.toJSONString(courseService.getCourseInfo(1L)));
        System.out.println(JSON.toJSONString(courseService.getCourseInfo(3L)));
    }

    @Test
    public void testGetCourseInfos() {
        System.out.println(JSON.toJSONString(courseService.getCourseInfos(new CourseInfosRequest(Arrays.asList(1L, 2L)))));
    }
}
