package com.demo.homepage.controller;

import com.alibaba.fastjson.JSON;
import com.demo.homepage.UserInfo;
import com.demo.homepage.service.IUserService;
import com.demo.homepage.vo.CreateUserRequest;
import com.demo.homepage.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h1>用户对外接口</h1>
 */
@Slf4j
@RestController
public class HomepageUserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/create/user")
    public UserInfo createUser(@RequestBody CreateUserRequest request) {
        log.info("<homepage-user>: create user -> {}", JSON.toJSONString(request));
        return userService.createUser(request);
    }

    @GetMapping("/get/user")
    public UserInfo getUserInfo(Long id) {
        log.info("<homepage-user>: get user id -> {}", id);
        return userService.getUserInfo(id);
    }

    @GetMapping("/get/user/course")
    public UserCourseInfo getUserCourseInfo(Long id) {
        log.info("<homepage-user>: get user course id -> {}", id);
        return userService.getUserCourseInfo(id);
    }
}
