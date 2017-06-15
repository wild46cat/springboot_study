package com.xueyou.demo.dao;

import com.xueyou.demo.pojo.Student;

import java.util.List;

/**
 * Created by wuxueyou on 2017/6/15.
 */
public interface StudentDao {
    List<Student> getAll();

    Student getById(int id);

    List<Student> getByNameLike(String name);

    Student getByIdAndName(int id,String name);
}