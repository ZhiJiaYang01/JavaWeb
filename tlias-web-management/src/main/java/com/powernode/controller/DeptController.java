package com.powernode.controller;

import com.powernode.anno.Log;
import com.powernode.pojo.Dept;
import com.powernode.pojo.Result;
import com.powernode.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

//    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    //    @RequestMapping(value = "/depts",method = RequestMethod.GET)//指定请求方式
//    查询部门
    @GetMapping
    public Result list() {
//        System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    @Log
    @DeleteMapping
    public Result delete(@RequestParam(value = "id", required = false) Integer id) {
//        System.out.println("根据id删除部门" + id);
        log.info("根据id删除部门:{}", id);
        deptService.deleteById(id);
        return Result.success();
    }

    @Log
    @PostMapping
    public Result add(@RequestBody Dept dept) {
//        System.out.println("添加部门"+dept);
        log.info("添加部门:{}", dept);
        deptService.add(dept);

        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer deptId) {
//        System.out.println("根据id查询部门" + deptId);
        log.info("根据id查询部门:{}", deptId);
        Dept dept = deptService.getInfo(deptId);
        return Result.success(dept);
    }

    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
//        System.out.println("根据id修改部门" + dept);
        log.info("根据id修改部门:{}", dept);
        deptService.update(dept);
        return Result.success();
    }
}
