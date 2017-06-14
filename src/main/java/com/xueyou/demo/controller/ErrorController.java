package com.xueyou.demo.controller;

import com.xueyou.demo.exp.CustomerException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wuxueyou on 2017/6/14.
 */
@RestController
@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(CustomerException.class)
    public Map<String,String> customerExceptionHandler(CustomerException ex){
        Map<String,String> res = new HashMap<>();
        ex.printStackTrace();
        res.put("errCode",ex.getErrCode());
        res.put("errMsg",ex.getErrMsg());
        return res;
    }

    @ExceptionHandler(SQLException.class)
    public Map<String,String> sqlExceptionHandler(SQLException ex){
        Map<String,String> res = new HashMap<>();
        ex.printStackTrace();
        res.put("errorCode","3306");
        res.put("errorMsg",ex.getMessage());
        return res;
    }

    @ExceptionHandler(Exception.class)
    public Map<String,String> exceptionHandler(Exception ex){
        Map<String,String> res = new HashMap<>();
        ex.printStackTrace();
        res.put("errorCode","3000");
        res.put("errorMsg",ex.getMessage());
        return res;
    }
}
