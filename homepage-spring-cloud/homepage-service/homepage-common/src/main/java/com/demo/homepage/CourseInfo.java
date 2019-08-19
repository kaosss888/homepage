package com.demo.homepage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h1>课程信息</h1>
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CourseInfo {

    private Long id;

    private String courseName;

    private Integer courseType;

    private String courseIcon;

    private String courseIntro;

    public static CourseInfo invalid() {
        return new CourseInfo(-1L, "", 0, "", "");
    }
}
