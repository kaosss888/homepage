package com.demo.homepage.service.impl;

import com.demo.homepage.CourseInfo;
import com.demo.homepage.CourseInfosRequest;
import com.demo.homepage.dao.HomepageCourseDao;
import com.demo.homepage.entity.HomepageCourse;
import com.demo.homepage.service.ICourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <h1>课程服务功能实现</h1>
 */
@Slf4j
@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private HomepageCourseDao homepageCourseDao;

    @Override
    public CourseInfo getCourseInfo(Long id) {

        Optional<HomepageCourse> course = homepageCourseDao.findById(id);
        return buildCourseInfo(course.orElse(HomepageCourse.invalid()));
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {

        if (CollectionUtils.isEmpty(request.getIds())) {
            return Collections.emptyList();
        }

        List<HomepageCourse> courses = homepageCourseDao.findAllById(request.getIds());

        return courses.stream().map(this::buildCourseInfo).collect(Collectors.toList());
    }

    private CourseInfo buildCourseInfo(HomepageCourse course) {
        return CourseInfo.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .courseType(course.getCourseType())
                .courseIcon(course.getCourseIcon())
                .courseIntro(course.getCourseIntro())
                .build();
    }
}
