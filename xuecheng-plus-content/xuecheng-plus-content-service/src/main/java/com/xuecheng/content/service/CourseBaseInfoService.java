package com.xuecheng.content.service;

import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.AddCourseDto;
import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.EditCourseDto;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 课程基本信息管理业务接口
 */
public interface CourseBaseInfoService {
    PageResult<CourseBase> queryCourseBaseList(Long companyId, PageParams pageParams, QueryCourseParamsDto queryCourseParamsDto);

    /**
     * 添加课程基本信息
     * @param companyId 教学机构id
     * @param addCourseDto 课程基本信息
     * @return
     */
    CourseBaseInfoDto createCourseBase(Long companyId, AddCourseDto addCourseDto);

    CourseBaseInfoDto getCourseBaseInfo(Long courseId);

    /**
     * 修改课程基本信息
     * @param companyId 机构id
     * @param editCourseDto 修改课程信息
     * @return 课程详细信息
     */
    CourseBaseInfoDto updateCourseBase(Long companyId, EditCourseDto editCourseDto);

    /**
     * 删除未发布的课程
     * @param courseId 课程id
     */
    void deleteCourseById(Long courseId);

}
