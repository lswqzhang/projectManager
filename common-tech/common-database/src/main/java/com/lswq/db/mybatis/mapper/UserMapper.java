package com.lswq.db.mybatis.mapper;

import com.lswq.db.mybatis.mode.Fruits;

public interface UserMapper {

    Fruits findUserById(int value);
}
