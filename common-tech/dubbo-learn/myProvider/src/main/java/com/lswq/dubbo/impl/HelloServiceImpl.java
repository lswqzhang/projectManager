package com.lswq.dubbo.impl;

import com.lswq.dubbo.HelloService;

/**
 * 实现类
 *
 * @author zhangshaowei
 */
public class HelloServiceImpl implements HelloService {

    @Override
    public String speakHello(String name) {
        return "hello， " + name;
    }
}
