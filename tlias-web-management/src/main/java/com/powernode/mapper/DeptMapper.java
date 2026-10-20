package com.powernode.mapper;

import com.powernode.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

//    @Results({
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime"),
//    })

    /*
     * 查询部门
     * */
    List<Dept> findAll();

    /*
     * 删除部门
     * */
    void deleteById(Integer id);

    /*
     * 新增部门
     * */
    void insert(Dept dept);

    /*
    * 修改回显部门名称
    * */
    Dept getInfo(Integer deptId);


    /*
    * 修改部门
    * */
    void update(Dept dept);
}
