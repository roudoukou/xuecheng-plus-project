package com.xuecheng.content.service.impl;

import com.xuecheng.content.mapper.CourseCategoryMapper;
import com.xuecheng.content.model.dto.CourseCategoryTreeDto;
import com.xuecheng.content.service.CourseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CourseCategoryServiceImpl implements CourseCategoryService {
    @Autowired
    private CourseCategoryMapper courseCategoryMapper;
    @Override
    public List<CourseCategoryTreeDto> queryTreeNodes(String id) {
        List<CourseCategoryTreeDto> courseCategoryTreeDtos
                = courseCategoryMapper.selectTreeNodes(id);

        // 将list转map, 以备使用, 排除 id 等于 1 的根节点
        Map<String, CourseCategoryTreeDto> mapTemp
                = courseCategoryTreeDtos
                .stream()
                .filter(item -> !id.equals(item.getId()))
                .collect(Collectors.toMap(
                        key -> key.getId(),
                        value -> value,
                        (key1, key2) -> key2
                ));

        // 最终返回的list
        ArrayList<CourseCategoryTreeDto> categoryTreeDtos = new ArrayList<>();

        // 依次遍历每个元素, 排除根节点
        courseCategoryTreeDtos.stream()
                .filter(item -> !id.equals(item.getId()))
                .forEach(item -> {
                    // 遍历每一项 , 如果是二级节点, 存入
                    if(item.getParentid().equals(id)) {
                        categoryTreeDtos.add(item);
                    }

                    // 找到当前节点的父节点
                    CourseCategoryTreeDto courseCategoryTreeDto = mapTemp.get(item.getParentid());
                    if (courseCategoryTreeDto != null) {
                        if (courseCategoryTreeDto.getChildrenTreeNodes() == null) {
                            courseCategoryTreeDto.setChildrenTreeNodes(new ArrayList<CourseCategoryTreeDto>());
                        }
                        // 下边开始往ChildrenTreeNodes属性中放子节点
                        courseCategoryTreeDto.getChildrenTreeNodes().add(item);
                    }
                });

        return categoryTreeDtos;
    }
}
