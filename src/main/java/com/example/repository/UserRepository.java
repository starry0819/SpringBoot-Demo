package com.example.repository;

import com.example.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author zhanghuanfa  2018-01-30 14:42
 */
@Repository
public class UserRepository {

    @Resource(name = "primaryJdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public User getUserById(Long id){
        final String sql = "SELECT * FROM user WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(User.class));
    }
}
