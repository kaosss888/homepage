package com.demo.homepage.client;

import com.demo.homepage.CourseInfo;
import com.demo.homepage.CourseInfosRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * <h1>访问课程微服务</h1>
 */
@FeignClient(value = "eureka-client-homepage-course", fallback = CourseClientHystrix.class)
public interface CourseClient {

    @RequestMapping(value = "/homepage-course/get/course", method = RequestMethod.GET)
    CourseInfo getCouseInfo(Long id);

    @RequestMapping(value = "/homepage-course/get/courses", method = RequestMethod.POST)
    List<CourseInfo> getCourseInfos(@RequestBody CourseInfosRequest request);
}
