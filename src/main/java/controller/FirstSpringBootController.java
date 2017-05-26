package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pojo.Student;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class FirstSpringBootController {

    @RequestMapping(value = "/greeting", method = {RequestMethod.GET})
    public String greeting() {
        return "sagddf";
    }

    @RequestMapping(value = "/greeting2", method = {RequestMethod.GET})
    public Student greeting2(int id,String name) {
        Student student = new Student(id, name);
        return student;
    }

    @RequestMapping(value = "/greeting3", method = {RequestMethod.GET})
    public List<Student> greeting3() {
        Student student = new Student(1, "xiaoming");
        Student student2 = new Student(2, "xiaohong");
        List<Student> studentList = new ArrayList<>();
        studentList.add(student);
        studentList.add(student2);
        return studentList;
    }

}

