package com.xuecheng.content.mapper;

import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.Teachplan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 课程计划 Mapper 接口
 * </p>
 *
 * @author itcast
 */
@Repository
public interface TeachplanMapper extends BaseMapper<Teachplan> {
    // 课程计划查询
    List<TeachplanDto> selectTreeNodes(Long courseId);

    TeachplanDto getChildrenList(Long id);

    Integer getTeachplanMax(@Param("courseId") Long courseId, @Param("parentid") Long parentid);

    Teachplan getLastOrderNode(@Param("orderby") Integer orderby, @Param("id") Long id);

    Teachplan getNextOrderNode(@Param("orderby") Integer orderby, @Param("id") Long id);

    Integer deleteTeachPlanByCourseId(Long courseId);

}
