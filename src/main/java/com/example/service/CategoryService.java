package com.example.service;

/**
 * @author zhanghuanfa  2018-02-05 17:57
 */
public interface CategoryService {

    /**
     * 事务注解在接口方法上
     *
     * @param id 主键id
     */
    void txInterfaceMethod(Integer id);


}
