package com.xuecheng.content;

import com.xuecheng.base.execption.XueChengPlusException;
import com.xuecheng.content.mapper.CourseTeacherMapper;
import com.xuecheng.content.model.po.CourseTeacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;

@SpringBootTest
public class CourseTeacherMapperTest {
    @Autowired
    private CourseTeacherMapper courseTeacherMapper;
    @Test
    public void addCourseTeacherTest() {
        CourseTeacher courseTeacher = new CourseTeacher();
        courseTeacher.setCourseId(75L);
        courseTeacher.setTeacherName("黄磊老师");
        courseTeacher.setPosition("教师职位");
        courseTeacher.setIntroduction("教师简介");

        Integer integer = courseTeacherMapper.addCourseTeacher(courseTeacher);
        System.out.println("integer = " + integer);

        System.out.println(courseTeacher.getId());
        System.out.println(courseTeacher);
    }

    @Test
    public void updateCourseTeacher() {

        CourseTeacher courseTeacher = new CourseTeacher();
        courseTeacher.setId(30L);
        courseTeacher.setCourseId(75L);
        courseTeacher.setTeacherName("雷神");
        courseTeacher.setPosition("教师职位");
        courseTeacher.setIntroduction("教师简介");

        Integer integer = null;
        try {
            integer = courseTeacherMapper.updateCourseTeacher(courseTeacher);
        } catch (DuplicateKeyException e) {
            throw new XueChengPlusException("当前名称已存在! ");
        }
        System.out.println("integer = " + integer);
        if (integer < 0) {
            throw new XueChengPlusException("修改失败");
        }

        System.out.println("courseTeacher = " + courseTeacher);
    }
}
