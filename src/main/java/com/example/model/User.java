package com.example.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhanghuanfa  2018-01-30 14:44
 */
@Data
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 5037267176893413803L;
    /**
     * 用户主键id
     */
    private Long id;
    /**
     * 真实姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String telephone;
    /**
     * 姓名拼音
     */
    private String pinyin;
    /**
     * 头像
     */
    private String portraitPath;
    /**
     * 用户添加来源
     */
    private String origin;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 创建该用户的id
     */
    private Long creatorId;
    /**
     * 最后操作时间
     */
    private Date lastUpdateTime;
    /**
     * 最后操作人id
     */
    private Long lastUpdaterId;
    /**
     * 用户状态：0-禁用，1-启用
     */
    private int status;
    /**
     * 用户登录名
     */
    private String username;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 所属机构id
     */
    private Long institutionId;
    /**
     * 用户类型
     */
    private int userType;
    /**
     * 删除状态：0-未删除，1-已删除
     */
    private int deleted;
    /**
     * 同一登录名，区别学生登录下标
     */
    private int multiIndex;
}
