package com.lswq.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 客户端
 *
 * @author zhangshaowei
 */
public class ConsumerClient {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
        HelloService helloService = (HelloService) context.getBean("helloService");
        String result = helloService.speakHello("yyf");
        System.err.println(result);
    }

}
