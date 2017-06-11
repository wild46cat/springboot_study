package com.xueyou.demo.controller;

import com.xueyou.demo.jdbc.DataSourcePool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by wuxueyou on 2017/6/7.
 */
@RestController
@RequestMapping("/jdbc")
public class JdbcTestController {

    @Autowired
    private DataSourcePool dataSourceConf;

    @RequestMapping("/getConn")
    public String getConn() {
        String result = "";
        if (dataSourceConf.getDataSource() == null) {
            result = "error";
        } else {
            result = dataSourceConf.getDataSource().getJdbcUrl();
            System.out.println(result);
        }

        return result;
    }

    @RequestMapping("/jdbcTemplateTest")
    public List<Map<String, Object>> testJdbcTemplate() {
        JdbcTemplate jdbcTemplate = null;
        List<Map<String, Object>> list = null;
        try {
            jdbcTemplate = new JdbcTemplate(dataSourceConf.getDataSource());
            list = jdbcTemplate.queryForList("select * from student");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return list;
    }
}
