package com.demo.homepage.dao;

import com.demo.homepage.entity.HomepageUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * <h1>HomepageUser Dao</h1>
 */
@Repository
public interface HomepageUserDao extends JpaRepository<HomepageUser, Long> {

    HomepageUser findByUsername(String username);
}
