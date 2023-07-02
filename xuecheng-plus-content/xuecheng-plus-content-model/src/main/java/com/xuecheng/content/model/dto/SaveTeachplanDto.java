package com.xuecheng.content.model.dto;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;

/**
 * 新增大章节, 小章节, 修改章节信息
 */
@Data
@ToString
public class SaveTeachplanDto {
    /***
     * 教学计划id
     */
    private Long id;

    /**
     * 课程计划名称
     */
    @NotEmpty(message = "课程计划名称不能为空")
    private String pname;

    /**
     * 课程计划父级Id
     */
    @NotEmpty(message = "课程计划父级Id不能为空")
    private Long parentid;

    /**
     * 层级，分为1、2、3级
     */
    @NotEmpty(message = "层级不能为空")
    private Integer grade;

    /**
     * 课程类型:1视频、2文档
     */
    private String mediaType;


    /**
     * 课程标识
     */
    @NotEmpty(message = "课程标识不能为空")
    private Long courseId;

    /**
     * 课程发布标识
     */
    @NotEmpty(message = "课程发布标识不能为空")
    private Long coursePubId;


    /**
     * 是否支持试学或预览（试看）
     */
    private String isPreview;

}