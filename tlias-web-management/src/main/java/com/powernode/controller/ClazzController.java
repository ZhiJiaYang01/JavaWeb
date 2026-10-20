package com.powernode.controller;

import com.powernode.anno.Log;
import com.powernode.pojo.*;
import com.powernode.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;

    @GetMapping
    public Result page(ClazzParam clazzParam) {
        log.info("分页查询:{}", clazzParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzParam);
        return Result.success(pageResult);
    }

    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除课程信息:{}", id);
        clazzService.delete(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("添加班级:{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    @GetMapping("/list")
    public Result listAll() {
        log.info("查询所有班级");
        List<Clazz> clazzList = clazzService.listAll();
        return Result.success(clazzList);
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer clazzId) {
        log.info("根据id查询班级:{}", clazzId);
        Clazz clazz = clazzService.getInfo(clazzId);
        return Result.success(clazz);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("根据id修改班级:{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }
}
