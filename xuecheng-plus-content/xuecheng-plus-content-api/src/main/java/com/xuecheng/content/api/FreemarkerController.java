package com.xuecheng.content.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * freemarker测试
 */
@Controller
public class FreemarkerController {

    // http://localhost:63040/content/testfreemarker
    @GetMapping("/testfreemarker")
    public ModelAndView test() {
        ModelAndView modelAndView = new ModelAndView();
        // 设置模型数据
        modelAndView.addObject("name", "小明");
        // 设置模板名称
        modelAndView.setViewName("test");
        return modelAndView;
    }

}
