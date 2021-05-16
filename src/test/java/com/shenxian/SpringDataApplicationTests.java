package com.shenxian;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringDataApplicationTests {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 默认Hikari数据源
     */
    @Test
    void contextLoads() {
        System.out.println(dataSource.getClass());

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from tab_county");
        for (Map<String, Object> map : maps) {
            System.out.println(map);
        }
    }

}
