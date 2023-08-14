package com.xuecheng.ucenter.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.xuecheng.ucenter.mapper.XcUserMapper;
import com.xuecheng.ucenter.model.dto.AuthParamsDto;
import com.xuecheng.ucenter.model.po.XcUser;
import com.xuecheng.ucenter.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    XcUserMapper xcUserMapper;

    @Autowired
    ApplicationContext applicationContext;

    /**
     * @description 根据账号查询用户信息
     * @param s  账号
     * @return org.springframework.security.core.userdetails.UserDetails
     * @author Mr.M
     * @date 2022/9/28 18:30
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AuthParamsDto authParamsDto = null;
        try {
            //将认证参数转为AuthParamsDto类型
            authParamsDto = JSON.parseObject(s, AuthParamsDto.class);
        } catch (Exception e) {
            log.info("认证请求不符合项目要求:{}",s);
            throw new RuntimeException("认证请求数据格式不对");
        }

        String authType = authParamsDto.getAuthType();
        AuthService authService
                = applicationContext.getBean(authType + "_authservice", AuthService.class);

        //开始认证
        authService.execute(authParamsDto);

        //账号
        String username = authParamsDto.getUsername();

        // 根据username账号查询数据库
        XcUser xcUser = xcUserMapper.selectOne(new LambdaQueryWrapper<XcUser>().eq(XcUser::getUsername, username));
        // 查询到用户不存在, 要返回null即可, Spring Security框架抛出异常用户不存在
        if (xcUser == null) {
            return null;
        }

        // 如果查到了用户拿到正确的密码, 最终封装成一个UserDetails对象的Spring Security框架返回, 由框架进行密码比对
        String password = xcUser.getPassword();

        xcUser.setPassword("");
        String userJSONString = JSON.toJSONString(xcUser);

        // 权限
        String[] authorities = {"test"};

        UserDetails userDetails = User.withUsername(userJSONString).password(password).authorities(authorities).build();
        return userDetails;
    }
}
