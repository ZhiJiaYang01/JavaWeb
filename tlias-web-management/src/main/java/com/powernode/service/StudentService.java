package com.powernode.service;

import com.powernode.pojo.*;

import java.util.List;

public interface StudentService {

    PageResult<Student> page(StudentParam studentParam);

    void delete(List<Integer> ids);

    void add(Student student);

    Student getInfo(Integer id);

    void update(Student student);

    void updateViolation(Integer id, Integer score);
}
