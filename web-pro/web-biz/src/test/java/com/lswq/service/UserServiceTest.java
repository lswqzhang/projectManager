package com.lswq.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 用户处理接口测试类
 *
 * @author zhangsw
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void selectUserByIdTest() {
        System.out.println(userService.selectUserById(1));
    }
    
}
