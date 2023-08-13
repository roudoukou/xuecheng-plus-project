package com.xuecheng.content.feignclient;

import com.xuecheng.content.model.po.CourseIndex;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description 搜索服务远程接口
 * @author Mr.M
 * @date 2022/9/20 20:29
 * @version 1.0
 */
@FeignClient(value = "search",
        fallbackFactory = SearchServiceClientFallbackFactory.class)
@RequestMapping("/search/index")
public interface SearchServiceClient {

    @PostMapping("/course")
    Boolean add(@RequestBody CourseIndex courseIndex);
}
