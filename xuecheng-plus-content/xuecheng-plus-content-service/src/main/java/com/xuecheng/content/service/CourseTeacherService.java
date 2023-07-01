package com.xuecheng.content.service;


import com.xuecheng.content.model.po.CourseTeacher;

import java.util.List;

public interface CourseTeacherService {
    /**
     * 查询教师接口
     * @param courseId
     * @return
     */
    List<CourseTeacher> getCourseTeacherList(Long courseId);

    /**
     * 添加教师接口
     * @param courseTeacher
     * @return
     */
    CourseTeacher addCourseTeacher(CourseTeacher courseTeacher);

    CourseTeacher updateCourseTeacher(CourseTeacher courseTeacher);

    void deleteCourseTeacher(Long courseId, Long id);
}
