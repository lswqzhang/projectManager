package com.lswq.controller;

import com.lswq.entity.User;
import com.lswq.service.UserServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/hello/{userId}")
    @ResponseBody
    public Object index(@PathVariable("userId") int userId) {
        log.info("search user id is {}", userId);
        User user = userServiceI.selectUserById(userId);
        log.info("search user data is {}", user);
        return user;
    }
}
