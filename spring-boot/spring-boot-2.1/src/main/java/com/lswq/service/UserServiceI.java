package com.lswq.service;

import com.lswq.entity.User;

/**
 * 用户管理接口
 *
 * @author zhangshaowei
 */
public interface UserServiceI {

    /**
     * 查询用户
     *
     * @param userId
     * @return
     */
    User selectUserById(Integer userId);

    /**
     * 保存用户信息
     *
     * @param user
     */
    User saveUser(User user);
}
