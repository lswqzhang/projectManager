package com.lswq.controller;

import com.lswq.entity.User;
import com.lswq.service.UserServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * rest controller
 *
 * @author zhangshaowei
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    private UserServiceI userServiceI;

    @GetMapping("/get/{userId}")
    @ResponseBody
    public Object get(@PathVariable("userId") int userId) {
        log.info("search user id is {}", userId);
        User user = userServiceI.selectUserById(userId);
        log.info("search user data is {}", user);
        return user;
    }


    @PostMapping("/save")
    @ResponseBody
    public Object save(@RequestBody User user) {
        boolean jdkProxy = AopUtils.isJdkDynamicProxy(userServiceI);
        boolean cglibProxy = AopUtils.isCglibProxy(userServiceI);
        log.info("jdk proxy is : {}, cglib proxy is : {}", jdkProxy, cglibProxy);
        log.info("save user info is {}", user);
        userServiceI.saveUser(user);
        log.info("after save user data is {}", user);
        return user;
    }


}
