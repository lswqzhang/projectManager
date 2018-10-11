package com.lswq;

import com.lswq.service.UserService;
import com.lswq.service.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application.xml")
public class LauncherTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserInfo() {
        User user = userService.selectUserById(1);
        System.err.println(this.toString() + "" + Thread.currentThread().getName());
    }

}
