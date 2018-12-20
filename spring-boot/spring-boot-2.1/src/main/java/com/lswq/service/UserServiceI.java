package com.lswq.service;

import com.lswq.entity.User;

/**
 * 用户管理接口
 *
 * @author zhangshaowei
 */
public interface UserServiceI {

    User selectUserById(Integer userId);

}
