package com.xuecheng.content.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuecheng.base.execption.CommonError;
import com.xuecheng.base.execption.XueChengPlusException;
import com.xuecheng.content.mapper.TeachplanMapper;
import com.xuecheng.content.mapper.TeachplanMediaMapper;
import com.xuecheng.content.model.dto.SaveTeachplanDto;
import com.xuecheng.content.model.dto.TeachplanDto;
import com.xuecheng.content.model.po.Teachplan;
import com.xuecheng.content.model.po.TeachplanMedia;
import com.xuecheng.content.service.TeachplanService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeachplanServiceImpl implements TeachplanService {

    @Autowired
    private TeachplanMapper teachplanMapper;

    @Autowired
    private TeachplanMediaMapper teachplanMediaMapper;

    @Override
    public List<TeachplanDto> findTeachplanTree(Long courseId) {
        List<TeachplanDto> teachplanDtos = teachplanMapper.selectTreeNodes(courseId);
        return teachplanDtos;
    }

    @Override
    public void saveTeachplan(SaveTeachplanDto saveTeachplanDto) {
        // 通过课程计划id判断是新增和修改
        Long teachplanId = saveTeachplanDto.getId();
        if (teachplanId == null) {
            // 新增
            Teachplan teachplan = new Teachplan();
            BeanUtils.copyProperties(saveTeachplanDto, teachplan);
            // 确定排序字段, 找到它的同级节点个数, 排序字段就是个数加1
            Long courseId = saveTeachplanDto.getCourseId();
            Long parentid = saveTeachplanDto.getParentid();
            int teachplanCount = getTeachplanCount(courseId, parentid);
            teachplan.setOrderby(teachplanCount);

            teachplanMapper.insert(teachplan);


        } else {
            // 修改
            Teachplan teachplan = teachplanMapper.selectById(teachplanId);
            // 将参数复制到teachplan
            BeanUtils.copyProperties(saveTeachplanDto, teachplan);
            teachplanMapper.updateById(teachplan);
        }
    }

    /**
     * 1、删除大章节，大章节下有小章节时不允许删除。
     * 2、删除大章节，大单节下没有小章节时可以正常删除。
     * 3、删除小章节，同时将关联的信息进行删除。
     * @param id 章节id
     */
    @Transactional
    @Override
    public void deleteTeachPlan(Long id) {
        Teachplan teachplan = teachplanMapper.selectById(id);
        if (teachplan == null) {
            throw new XueChengPlusException("该章节不存在!");
        }
        if (teachplan.getParentid().equals(0L)) {
            // 删除大章节
            Integer childrenList = getChildrenList(id);

            if (childrenList <= 0) {
                // 删除大章节
                teachplanMapper.deleteById(id);
            } else {
                throw new XueChengPlusException("120409", "课程计划信息还有子级信息, 无法操作");
            }

        } else {
            // 删除小章节
            teachplanMapper.deleteById(id);
            // 删除对应的媒资信息
            LambdaQueryWrapper<TeachplanMedia> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(TeachplanMedia::getTeachplanId, id);
            int delete = teachplanMediaMapper.delete(queryWrapper);
            if (delete < 0) {
                throw new XueChengPlusException(CommonError.UNKOWN_ERROR.getErrMessage());
            }
        }
    }

    /**
     * 查询当前章节id下是否有子章节
     * @param id 章节id
     * @return 章节list
     */
    private Integer getChildrenList(Long id) {
        TeachplanDto childrenList = teachplanMapper.getChildrenList(id);

        System.out.println(childrenList);
        if (childrenList != null) {
            return childrenList.getTeachPlanTreeNodes().size();
        } else {
            return 0;
        }
    }

    private int getTeachplanCount(Long courseId, Long parentid) {
        LambdaQueryWrapper<Teachplan> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Teachplan::getCourseId, courseId).eq(Teachplan::getParentid, parentid);
        Integer integer = teachplanMapper.selectCount(queryWrapper);
        return integer+1;
    }
}
