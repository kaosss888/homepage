package com.demo.homepage.dao;

import com.demo.homepage.entity.HomepageCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomepageCourseDao extends JpaRepository<HomepageCourse, Long> {

}
