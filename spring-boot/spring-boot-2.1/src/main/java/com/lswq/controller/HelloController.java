package com.lswq.controller;

import com.lswq.entity.User;
import com.lswq.service.UserServiceI;
import com.lswq.utils.NetworkUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

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


    @GetMapping("/hello/{name}")
    @ResponseBody
    public Object hello(@PathVariable("name") String name, HttpServletRequest request) {
        String ipAddress = null;
        try {
            ipAddress = NetworkUtil.getIpAddress(request);
        } catch (IOException e) {
            log.error("get the ip error, and the request ip is {}", e);
        }
        log.info("user name is {}, and the request ip is {}", name, ipAddress);
        return "hello, " + name + "the ip address is " + ipAddress;
    }

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
