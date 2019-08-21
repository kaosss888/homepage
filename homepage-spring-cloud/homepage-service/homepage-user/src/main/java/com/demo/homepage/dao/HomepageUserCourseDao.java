package com.demo.homepage.dao;

import com.demo.homepage.entity.HomepageUserCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <h1>HomepageUserCourse Dao</h1>
 */
@Repository
public interface HomepageUserCourseDao extends JpaRepository<HomepageUserCourse, Long> {

    List<HomepageUserCourse> findAllByUserId(Long userId);
}
