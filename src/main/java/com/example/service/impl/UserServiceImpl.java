package com.example.service.impl;

import com.example.model.User;
import com.example.repository.UserRepository;
import com.example.service.UserService;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhanghuanfa  2018-01-30 17:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }
}
