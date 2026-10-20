package com.powernode.controller;

import com.powernode.anno.Log;
import com.powernode.pojo.*;
import com.powernode.service.StudentService;
import com.sun.net.httpserver.Authenticator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public Result page(StudentParam studentParam) {
        log.info("分页查询:{}", studentParam);
        PageResult<Student> pageResult = studentService.page(studentParam);
        return Result.success(pageResult);
    }

    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable String ids){
        log.info("批量删除学员，ids字符串:{}", ids);
        List<Integer> idList = Arrays.stream(ids.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        studentService.delete(idList);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("添加学员:{}", student);
        studentService.add(student);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根据id查询学员:{}", id);
        Student student = studentService.getInfo(id);
        return Result.success(student);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学员信息:{}", student);
        studentService.update(student);
        return Result.success();
    }

    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id, @PathVariable Integer score){
        studentService.updateViolation(id,score);
        return Result.success();
    }
}
