package com.xuecheng.content.service;

import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * 课程计划管理相关接口
 */
public interface TeachplanService {
    /**
     * 根据课程id查询课程计划
     * @param courseId 课程计划
     * @return
     */
    List<TeachplanDto> findTeachplanTree(Long courseId);

    /**
     * 新增/修改/保存课程计划
     * @param saveTeachplanDto
     */
    void saveTeachplan(@RequestBody SaveTeachplanDto saveTeachplanDto);

    void deleteTeachPlan(Long id);

    void moveUpTeachPlan(Long id);

    void moveDownTeachPlan(Long id);

    /**
     * 通过课程id删除当前所有的教学计划
     * @param courseId 传入一个课程id
     */
    void deleteTeachPlanByCourseId(Long courseId);
}
