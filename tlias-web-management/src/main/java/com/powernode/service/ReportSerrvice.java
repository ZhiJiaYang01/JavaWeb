package com.powernode.service;

import com.powernode.pojo.GenderrOption;
import com.powernode.pojo.JobOption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface ReportSerrvice {

    JobOption getEmpJobData();

    List<Map<String,Integer>> getEmpGenderData();

    List<Map<String, Integer>> getstudentDegreeData();

    JobOption getstudentCountData();
}
