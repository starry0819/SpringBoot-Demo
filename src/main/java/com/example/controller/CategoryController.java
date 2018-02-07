package com.example.controller;

import com.example.response.ResultData;
import com.example.service.CategoryService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhanghuanfa  2018-02-06 11:02
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Resource
    private CategoryService categoryService;

    @RequestMapping("/demo")
    public ResultData demo(Integer id) {
        categoryService.txInterfaceMethod(id);
        return ResultData.succeed("hello" + id);
    }
}
