package com.xuecheng.content.mapper;

import com.xuecheng.content.model.po.CourseTeacher;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程-教师关系表 Mapper 接口
 * </p>
 *
 * @author itcast
 */
@Repository
public interface CourseTeacherMapper extends BaseMapper<CourseTeacher> {

    List<CourseTeacher> getCourseTeacherList(Long courseId);

    Integer addCourseTeacher(CourseTeacher courseTeacher);

    Integer updateCourseTeacher(CourseTeacher courseTeacher);

    Integer deleteCourseTeacher(Long courseId, Long id);

}
