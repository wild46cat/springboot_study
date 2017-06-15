package com.xueyou.demo.controller;

import com.xueyou.demo.dao.StudentDao;
import com.xueyou.demo.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wuxueyou on 2017/6/15.
 */
@RestController
@RequestMapping("/mybatis")
public class mybatisTestController {
    @Autowired
    public StudentDao studentDao;

    @RequestMapping("/getAll")
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @RequestMapping("/getById")
    public Student getById(int id) {
        return studentDao.getById(id);
    }

    @RequestMapping("/getByNameLike")
    public List<Student> getByNameLike(String name) {
        return studentDao.getByNameLike(name);
    }

    @RequestMapping("/getByIdAndName")
    public Student getByIdAndName(int id,String name){
        return studentDao.getByIdAndName(id,name);
    }

}
