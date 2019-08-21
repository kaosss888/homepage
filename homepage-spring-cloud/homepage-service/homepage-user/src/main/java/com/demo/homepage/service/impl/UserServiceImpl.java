package com.demo.homepage.service.impl;

import com.demo.homepage.CourseInfo;
import com.demo.homepage.CourseInfosRequest;
import com.demo.homepage.UserInfo;
import com.demo.homepage.client.CourseClient;
import com.demo.homepage.dao.HomepageUserCourseDao;
import com.demo.homepage.dao.HomepageUserDao;
import com.demo.homepage.entity.HomepageUser;
import com.demo.homepage.entity.HomepageUserCourse;
import com.demo.homepage.service.IUserService;
import com.demo.homepage.vo.CreateUserRequest;
import com.demo.homepage.vo.UserCourseInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private HomepageUserDao homepageUserDao;

    @Autowired
    private HomepageUserCourseDao homepageUserCourseDao;

    @Autowired
    private CourseClient courseClient;

    @Override
    public UserInfo createUser(CreateUserRequest request) {
        if (!request.validate()) {
            return UserInfo.invalid();
        }

        HomepageUser user = homepageUserDao.findByUsername(request.getUsername());

        if (null != user) {
            return UserInfo.invalid();
        }

        HomepageUser user1 = homepageUserDao.save(new HomepageUser(request.getUsername(), request.getEmail()));
        return new UserInfo(user1.getId(), user1.getUsername(), user1.getEmail());
    }

    @Override
    public UserInfo getUserInfo(Long id) {

        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserInfo.invalid();
        }

        HomepageUser curUser = user.get();
        return new UserInfo(curUser.getId(), curUser.getUsername(), curUser.getEmail());
    }

    @Override
    public UserCourseInfo getUserCourseInfo(Long id) {

        Optional<HomepageUser> user = homepageUserDao.findById(id);
        if (!user.isPresent()) {
            return UserCourseInfo.invalid();
        }

        HomepageUser homepageUser = user.get();

        UserInfo userInfo = new UserInfo(homepageUser.getId(), homepageUser.getUsername(), homepageUser.getEmail());
        List<HomepageUserCourse> userCourses = homepageUserCourseDao.findAllByUserId(id);

        if (CollectionUtils.isEmpty(userCourses)) {
            return new UserCourseInfo(userInfo, Collections.emptyList());
        }

        List<CourseInfo> courseInfos = courseClient.getCourseInfos(
                new CourseInfosRequest(
                        userCourses.stream().map(HomepageUserCourse::getCourseId).collect(Collectors.toList())
                ));

        return new UserCourseInfo(userInfo, courseInfos);
    }
}
