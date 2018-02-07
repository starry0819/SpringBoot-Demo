package com.example.service;

import com.example.model.User;

/**
 * @author zhanghuanfa  2018-01-30 17:02
 */
public interface UserService {
    /**
     * 根据id获取User对象
     * @param id 用户主键id
     * @return user对象
     */
    User getUserById(Long id);
}
