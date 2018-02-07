package com.example.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * @author zhanghuanfa  2018-01-29 18:00
 */
@Component
@ConfigurationProperties(prefix = "home")
@Data
public class HomeProperties {
    /**
     * 省份
     */
    private String province;
    /**
     * 城市
     */
    private String city;
    /**
     * 描述
     */
    private String description;
}
