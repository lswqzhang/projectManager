package com.lswq.mapper;

import com.lswq.entity.User;

/**
 * 用户查询
 *
 * @author zhangshaowei
 */
public interface UserMapper {

    /**
     * 通过ID查询用户
     *
     * @param userId
     * @return
     */
    User selectUserById(Integer userId);

}
