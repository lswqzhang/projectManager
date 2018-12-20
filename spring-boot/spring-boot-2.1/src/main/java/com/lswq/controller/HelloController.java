package com.lswq.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * rest controller
 *
 * @author zhangshaowei
 */
@Slf4j
@RestController
public class HelloController {
    @PostMapping("/hello")
    public String index() {
        log.info("test interface");
        return "Hello World";
    }
}
