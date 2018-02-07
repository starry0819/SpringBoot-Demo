package com.example.service.impl;

import com.example.service.CategoryService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author zhanghuanfa  2018-02-06 10:33
 */
@SpringBootTest
@EnableTransactionManagement
@RunWith(SpringJUnit4ClassRunner.class)
public class CategoryServiceImplTest {

    @Resource
    private CategoryService categoryService;

    @Test
    public void txInterfaceMethod() throws Exception {
        categoryService.txInterfaceMethod(1);
    }
}