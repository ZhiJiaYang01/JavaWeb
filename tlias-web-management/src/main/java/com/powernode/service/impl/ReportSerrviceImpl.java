package com.powernode.service.impl;

import com.powernode.mapper.EmpMapper;
import com.powernode.mapper.StudentMapper;
import com.powernode.pojo.GenderrOption;
import com.powernode.pojo.JobOption;
import com.powernode.service.ReportSerrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportSerrviceImpl implements ReportSerrvice {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public JobOption getEmpJobData() {
        List<Map<String, Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map<String,Integer>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    @Override
    public List<Map<String, Integer>> getstudentDegreeData() {
        return studentMapper.countstudentDegreeData();
    }

    @Override
    public JobOption getstudentCountData() {
        List<Map<String,Object>> list = studentMapper.countstudentCountData();
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("name")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("value")).toList();
        return new JobOption(jobList, dataList);
    }
}
