package com.example.controller;

import com.example.model.User;
import com.example.response.ResultData;
import com.example.service.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhanghuanfa  2018-01-30 17:08
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/getById", method = RequestMethod.GET)
    public ResultData getUserById(Long id) {
        User userById = userService.getUserById(id);
        return ResultData.succeed(userById);
    }
}
