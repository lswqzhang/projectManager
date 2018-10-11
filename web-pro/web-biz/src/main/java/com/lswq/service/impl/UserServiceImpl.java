package com.lswq.service.impl;

import com.lswq.service.UserService;
import com.lswq.service.entity.User;
import com.lswq.service.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired  
    private UserMapper userMapper;  
  
	@Override
    public User selectUserById(Integer userId) {
        return userMapper.selectUserById(userId);  
          
    } 
}
