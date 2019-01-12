package com.lswq.service.impl;

import com.lswq.entity.User;
import com.lswq.mapper.UserMapper;
import com.lswq.service.UserServiceI;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户查询处理
 *
 * @author zhangshaowei
 */
@Slf4j
@Service
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserById(Integer userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public User saveUser(User user) {
        userMapper.saveUserInfo(user);
        return user;
    }
}
