package com.example.service.impl;

import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author zhanghuanfa  2018-02-05 17:57
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String HELLO = "hello";
    @Resource
    private CategoryRepository categoryRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void txInterfaceMethod(Integer id) {
        String name = getName(id);
        Integer execute;
        if (HELLO.equals(name)) {
            execute = categoryRepository.updateToWorld(id);
        } else {
            execute = categoryRepository.updateToHello(id);
        }
        int a = 1/0;
        System.out.println(execute);
    }

    private String getName(Integer id) {
        return categoryRepository.getName(id);
    }
}
