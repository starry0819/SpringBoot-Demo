package com.example;

import com.example.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author zhanghuanfa  2018-01-30 18:29
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class JdbcTemplateTests {

    @Resource(name = "primaryJdbcTemplate")
    private JdbcTemplate primaryJdbcTemplate;
    @Resource(name = "secondaryJdbcTemplate")
    private JdbcTemplate secondaryJdbcTemplate;

    @Test
    public void dataSourceTest() {
        final String sql = "SELECT * FROM user WHERE id = ? ";
        User user2 =
            secondaryJdbcTemplate.queryForObject(sql, new Object[]{1550}, new BeanPropertyRowMapper<>(User.class));
        User user1 =
            primaryJdbcTemplate.queryForObject(sql, new Object[]{1550}, new BeanPropertyRowMapper<>(User.class));
        System.out.println(user1);
        System.out.println(user2);
    }

}
