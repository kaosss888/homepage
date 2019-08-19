package com.demo.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.demo.homepage.CourseInfo;
import com.demo.homepage.CourseInfosRequest;
import com.demo.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h1>课程对外服务接口</h1>
 */
@Slf4j
@RestController
public class HomepageCourseController {

    @Autowired
    private ICourseService courseService;

    @GetMapping("/get/course/{id}")
    public CourseInfo getCourseInfo(@PathVariable("id") Long id) {
        log.info("<homepage-course>: get course -> {}", id);
        return courseService.getCourseInfo(id);
    }

    @PostMapping("/get/courses")
    public List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request) {
        log.info("<homepage-course>: get courses -> {}", JSON.toJSONString(request));
        return courseService.getCourseInfos(request);
    }

}
