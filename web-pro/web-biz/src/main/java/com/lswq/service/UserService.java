package com.lswq.service;

import com.lswq.service.entity.User;

/**
 * 用户处理接口
 *
 * @author zhangsw
 */
public interface UserService {

    User selectUserById(Integer userId);
}
