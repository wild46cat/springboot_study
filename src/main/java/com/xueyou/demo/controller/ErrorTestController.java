package com.xueyou.demo.controller;

import com.xueyou.demo.exp.CustomerException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

/**
 * Created by wuxueyou on 2017/6/14.
 */
@RestController
@RequestMapping("/error")
public class ErrorTestController {

    @RequestMapping("/test")
    public String errorTest() throws Exception {
        throw new CustomerException("001", "001error,please fix it");
    }

    @RequestMapping("/test2")
    public String errorTest2() throws Exception {
        throw new SQLException("sql exception");
    }

    @RequestMapping("/test3")
    public String errorTest3() throws Exception {
        throw new Exception("this is a new Exception");
    }
}
