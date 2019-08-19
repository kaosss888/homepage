package com.demo.homepage.service;

import com.demo.homepage.CourseInfo;
import com.demo.homepage.CourseInfosRequest;

import java.util.List;

/**
 * <h1>课程相关服务接口定义</h1>
 */
public interface ICourseService {

    CourseInfo getCourseInfo(Long id);

    List<CourseInfo> getCourseInfos(CourseInfosRequest request);
}
