package com.example.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zhanghuanfa  2018-02-05 17:58
 */
@Component
public class CategoryRepository {
    @Resource(name = "primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public Integer updateToWorld(Integer id) {
        final String sql = "UPDATE category SET name = 'world' WHERE id = ? ";
        return jdbcTemplate.update(sql, id);
    }

    public Integer updateToHello(Integer id) {
        final String sql = "UPDATE category SET name = 'hello' WHERE id = ? ";
        return jdbcTemplate.update(sql, id);
    }

    public String getName(Integer id) {
        final String sql = "SELECT name FROM category WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, String.class);
    }
}
