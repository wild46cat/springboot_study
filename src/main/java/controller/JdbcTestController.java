package controller;

import jdbc.DataSourcePool;
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
    public String testJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSourceConf.getDataSource());
        List<Map<String,Object>> list = jdbcTemplate.queryForList("select * from student");
        for (Map<String, Object> stringObjectMap : list) {
            System.out.println(stringObjectMap.keySet());
            for (String s : stringObjectMap.keySet()) {
                System.out.println(stringObjectMap.get(s));
            }
        }
        return "ok";
    }
}
