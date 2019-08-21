package com.demo.homepage.client;

import com.demo.homepage.CourseInfo;
import com.demo.homepage.CourseInfosRequest;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

/**
 * <h1>熔断降级策略</h1>
 */
@Component
public class CourseClientHystrix implements CourseClient {

    @Override
    public CourseInfo getCouseInfo(Long id) {
        return CourseInfo.invalid();
    }

    @Override
    public List<CourseInfo> getCourseInfos(CourseInfosRequest request) {
        return Collections.emptyList();
    }
}
