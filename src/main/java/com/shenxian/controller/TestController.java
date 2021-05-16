package com.shenxian.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: immor
 * @Date: 2021/5/16
 */
@RestController
public class TestController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/list")
    public List<Map<String, Object>> list() {
        return jdbcTemplate.queryForList("select * from tab_county");
    }

    @GetMapping("/update/{countyId}")
    public String update(@PathVariable("countyId") String countyId) {
        String sql = "update tab_county set county_name = ? where county_id = ?";
        Object[] params = new Object[2];
        params[0] = "test_name";
        params[1] = countyId;
        jdbcTemplate.update(sql, params);
        return "deleteOk";
    }

    @GetMapping("/delete/{countyId}")
    public String delete(@PathVariable("countyId") String countyId) {
        jdbcTemplate.update("delete from tab_county where county_id = ?", countyId);
        return "deleteOk";
    }
}
