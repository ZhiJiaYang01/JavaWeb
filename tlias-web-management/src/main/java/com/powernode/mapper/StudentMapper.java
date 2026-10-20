package com.powernode.mapper;

import com.powernode.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    List<Student> list(StudentParam studentParam);

    void delete(List<Integer> ids);

    void add(Student student);

    Student getInfo(Integer id);

    void update(Student student);

    void updateViolation(Integer id, Integer score);

    List<Map<String, Integer>> countstudentDegreeData();

    List<Map<String, Object>> countstudentCountData();
}
