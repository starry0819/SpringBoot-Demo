package com.example.controller;

import com.example.model.HomeProperties;
import com.example.response.ResultData;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import io.swagger.annotations.ApiOperation;

/**
 * @author zhanghuanfa  2018-01-29 15:23
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    @Value("${com.example.blog.title}")
    private String title;
    @Value("${com.example.blog.id}")
    private Integer blogId;
    @Resource
    private HomeProperties homeProperties;

    @RequestMapping("/demoWithName")
    @ApiOperation(value="获取用户列表", notes="hello111")
    public ResultData demoWithName(String name){
        return ResultData.succeed("Hello World, " + name);
    }

    @ApiOperation(value = "demo1111",notes = "Spring Boot的DemoController的helloworld")
    @RequestMapping(value = "/demo", method = RequestMethod.GET)
    public ResultData demo(){
        return ResultData.succeed("Hello World");
    }

    @RequestMapping("/title")
    public ResultData title(){
        return ResultData.succeed(title+blogId);
    }

    @RequestMapping("/customProperties")
    public ResultData customProperties(){
        return ResultData.succeed(homeProperties);
    }
}
