package com.xueyou.demo.controller;

import com.xueyou.demo.pojo.Student;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wuxueyou on 2017/6/13.
 */
@RestController
@CrossOrigin
@RequestMapping("/request")
public class RequestController {

    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    public List<Student> getStudentList() {
        Student student = new Student(1, "xiaoming");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        return studentList;
    }


    @RequestMapping(value = "/post", method = {RequestMethod.POST})
    public List<Student> postStudentList() {
        Student student = new Student(2, "xiaohong");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        return studentList;
    }


}
