package com.demo.homepage.service;

import com.demo.homepage.UserInfo;
import com.demo.homepage.vo.CreateUserRequest;
import com.demo.homepage.vo.UserCourseInfo;

import java.util.List;

/**
 * <h1>用户相关服务接口</h1>
 */
public interface IUserService {

    UserInfo createUser(CreateUserRequest request);

    UserInfo getUserInfo(Long id);

    UserCourseInfo getUserCourseInfo(Long id);
}
