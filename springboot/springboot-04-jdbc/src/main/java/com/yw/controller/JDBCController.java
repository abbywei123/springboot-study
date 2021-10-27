package com.yw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    //查询数据可的所有信息
    @GetMapping("/userList")
    public List<Map<String,Object>> userList(){
        String sql="select * from mybatis.user";

        List<Map<String, Object>> list_maps = jdbcTemplate.queryForList(sql);

        return list_maps;
    }

    @GetMapping("/addUser")
    public String addUser(){
        String sql="insert into mybatis.user(id,name,pwd) values (7,'小康','12345')";
        jdbcTemplate.update(sql);
        return "ok";
    }

    @GetMapping("/updateUser")
    public String updateUser(){
        String sql="update mybatis.user set name='小康2' where id=7";
        jdbcTemplate.update(sql);
        return "ok";
    }

}
