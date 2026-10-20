package com.powernode.service.impl;

import com.github.pagehelper.PageHelper;
import com.powernode.mapper.StudentMapper;
import com.powernode.pojo.*;
import com.powernode.service.StudentService;
import com.powernode.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(StudentParam studentParam) {
        PageHelper.startPage(studentParam.getPage(), studentParam.getPageSize());
        List<Student> studentList = studentMapper.list(studentParam);
        // 直接调用工具方法
        return PageUtil.buildPageResult(studentList);
    }

    @Override
    public void delete(List<Integer> ids) {
        studentMapper.delete(ids);
    }

    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.add(student);
    }

    @Override
    public Student getInfo(Integer id) {
        return studentMapper.getInfo(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void updateViolation(Integer id, Integer score) {
        studentMapper.updateViolation(id,score);
    }
}
