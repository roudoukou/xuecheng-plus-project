package com.xuecheng.content.api;

import com.xuecheng.base.execption.ValidationGroups;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.model.dto.AddCourseDto;
import com.xuecheng.content.model.dto.CourseBaseInfoDto;
import com.xuecheng.content.model.dto.EditCourseDto;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import com.xuecheng.content.service.CourseBaseInfoService;
import com.xuecheng.content.utils.SecurityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Api(value = "课程信息编辑接口", tags = "课程信息编辑接口")
@RestController
public class CourseBaseInfoController {

    @Autowired
    private CourseBaseInfoService courseBaseInfoService;

    @ApiOperation("课程查询接口")
    @PostMapping("/course/list")
    @PreAuthorize("hasAuthority('xc_teachmanager_course_list')")
    public PageResult<CourseBase> list(PageParams pageParams, @RequestBody(required = false) QueryCourseParamsDto queryCourseParamsDto) {

        SecurityUtil.XcUser user = SecurityUtil.getUser();
        Long companyId = null;
        if (StringUtils.isNotEmpty(user.getCompanyId())) {
            companyId = Long.parseLong(user.getCompanyId());
        }

        PageResult<CourseBase> courseBasePageResult =
                courseBaseInfoService.queryCourseBaseList(companyId, pageParams, queryCourseParamsDto);
        return courseBasePageResult;
    }

    @ApiOperation("新增课程基础信息")
    @PostMapping("/course")
    public CourseBaseInfoDto createCourseBase(
            @RequestBody @Validated(ValidationGroups.Update.class) AddCourseDto addCourseDto) {

        CourseBaseInfoDto courseBase = courseBaseInfoService.createCourseBase(1232141425L, addCourseDto);
        return courseBase;
    }

    @ApiOperation("根据课程id查询接口")
    @GetMapping("/course/{courseId}")
    public CourseBaseInfoDto getCourseBaseById(@PathVariable Long courseId) {
        // Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        // log.info("当前用户身份: {}", principal);

        SecurityUtil.XcUser user = SecurityUtil.getUser();
        log.info("当前用户身份: {}", user);

        CourseBaseInfoDto courseBaseInfo = courseBaseInfoService.getCourseBaseInfo(courseId);
        return courseBaseInfo;
    }

    @ApiOperation("删除未发布课程")
    @DeleteMapping("/course/{courseId}")
    public void deleteCourseBaseById(@PathVariable Long courseId) {
        courseBaseInfoService.deleteCourseById(courseId);
    }

    @ApiOperation("修改课程")
    @PutMapping("/course")
    public CourseBaseInfoDto modifyCourseBase(
            @RequestBody @Validated(ValidationGroups.Update.class) EditCourseDto editCourseDto) {
        // 获取到用户所属机构的id
        Long companyId = 1232141425L;
        CourseBaseInfoDto courseBaseInfoDto = courseBaseInfoService.updateCourseBase(companyId, editCourseDto);
        return courseBaseInfoDto;
    }
}

