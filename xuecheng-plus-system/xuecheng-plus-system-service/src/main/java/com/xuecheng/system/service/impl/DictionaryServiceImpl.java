package com.xuecheng.system.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuecheng.system.mapper.DictionaryMapper;
import com.xuecheng.system.model.dto.DictionaryDto;
import com.xuecheng.system.model.po.Dictionary;
import com.xuecheng.system.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;

/**
 * <p>
 * 数据字典 服务实现类
 * </p>
 *
 * @author itcast
 */
@Slf4j
@Service
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, Dictionary> implements DictionaryService {

    @Override
    public List<Dictionary> queryAll() {

        List<Dictionary> list = this.list();


        return list;
    }

    @Override
    public Dictionary getByCode(String code) {


        LambdaQueryWrapper<Dictionary> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Dictionary::getCode, code);

        Dictionary dictionary = this.getOne(queryWrapper);


        return dictionary;
    }

    @Override
    public String getCodeByDictionary(String desc) {
        // 未审核
        List<Dictionary> dictionaryList = queryAll();
        for (Dictionary dict : dictionaryList) {
            String itemValues = dict.getItemValues();
            System.out.println(itemValues);
            JSONArray objects = JSON.parseArray(itemValues);
            for (Object object : objects) {
                JSONObject obj = (JSONObject) object;
                String codeStr = obj.getString("code");
                String descStr = obj.getString("desc");
                if (descStr.equals(desc)) {
                    System.out.println(codeStr);
                    return codeStr;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String desc = "未审核";
        String itemValues = "[{\"code\":\"002001\",\"desc\":\"审核未通过\"},{\"code\":\"002002\",\"desc\":\"未审核\"},{\"code\":\"002003\",\"desc\":\"审核通过\"}]";
        // Object parse = JSON.parse(itemValues);
        JSONArray objects = JSON.parseArray(itemValues);
        for (Object object : objects) {
            JSONObject obj = (JSONObject) object;
            String codeStr = obj.getString("code");
            String descStr = obj.getString("desc");
            if (descStr.equals(desc)) {
                System.out.println(codeStr);
            }
        }
    }
}
