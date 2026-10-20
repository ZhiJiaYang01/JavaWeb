package com.powernode.controller;

import com.powernode.pojo.GenderrOption;
import com.powernode.pojo.JobOption;
import com.powernode.pojo.Result;
import com.powernode.service.ReportSerrvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportSerrvice reportSerrvice;

    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("统计员工职位人数");
        JobOption jobOption = reportSerrvice.getEmpJobData();
        return Result.success(jobOption);
    }

    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("统计员工性别人数");
        List<Map<String,Integer>> list = reportSerrvice.getEmpGenderData();
        return Result.success(list);
    }

    @GetMapping("/studentDegreeData")
    public Result getstudentDegreeData(){
        log.info("统计学员的学历信息");
        List<Map<String,Integer>> list = reportSerrvice.getstudentDegreeData();
        return Result.success(list);
    }

    @GetMapping("/studentCountData")
    public Result getstudentCountData(){
        log.info("统计每一个班级的人数");
        JobOption jobOption = reportSerrvice.getstudentCountData();
        return Result.success(jobOption);
    }
}
