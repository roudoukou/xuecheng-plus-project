package com.xuecheng.content.service.impl;

import com.xuecheng.base.execption.XueChengPlusException;
import com.xuecheng.content.mapper.CourseTeacherMapper;
import com.xuecheng.content.model.po.CourseTeacher;
import com.xuecheng.content.service.CourseTeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@Transactional
public class CourseTeacherServiceImpl implements CourseTeacherService {

    @Autowired
    private CourseTeacherMapper courseTeacherMapper;

    @Override
    public List<CourseTeacher> getCourseTeacherList(Long courseId) {
        return courseTeacherMapper.getCourseTeacherList(courseId);
    }

    @Override
    public CourseTeacher addCourseTeacher(CourseTeacher courseTeacher) {
        if (courseTeacher.getId() != null) {
            return updateCourseTeacher(courseTeacher);
        }
        Integer integer = courseTeacherMapper.addCourseTeacher(courseTeacher);
        if (integer <= 0) {
            throw new XueChengPlusException("插入失败...");
        }
        return courseTeacher;
    }

    @Override
    public CourseTeacher updateCourseTeacher(CourseTeacher courseTeacher) {

        Integer integer = null;
        try {
            integer = courseTeacherMapper.updateCourseTeacher(courseTeacher);
        } catch (DuplicateKeyException e) {
            throw new XueChengPlusException("当前名称已存在! ");
        }
        // System.out.println("integer = " + integer);
        if (integer < 0) {
            throw new XueChengPlusException("修改失败");
        }

        // System.out.println("courseTeacher = " + courseTeacher);

        return courseTeacher;
    }

    @Override
    public void deleteCourseTeacher(Long courseId, Long id) {
        Integer integer = courseTeacherMapper.deleteCourseTeacher(courseId, id);
        if (integer < 0) {
            throw new XueChengPlusException("删除失败");
        }
    }
}
