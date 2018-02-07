package com.example.service;

import com.example.repository.CategoryRepository;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhanghuanfa  2018-02-06 10:23
 */
@Service
public class CategoryBusinessImpl {
    @Resource
    private CategoryRepository categoryRepository;
    @Resource
    private CategoryService categoryService;

}
