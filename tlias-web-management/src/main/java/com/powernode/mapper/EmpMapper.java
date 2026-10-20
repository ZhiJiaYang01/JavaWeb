package com.powernode.mapper;

import com.powernode.pojo.Emp;
import com.powernode.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/*
* 操作员工基本信息
* */
@Mapper
public interface EmpMapper {



    List<Emp> list(EmpQueryParam empQueryParam);

    void insert(Emp emp);

    void deleteByIds(List<Integer> ids);

    Emp getById(Integer id);

    void updateById(Emp emp);

    List<Map<String,Object>> countEmpJobData();

    List<Map<String, Integer>> countEmpGenderData();

    Emp selectByUsernameAndPassword(Emp emp);

    /*
    * 原始分页查询实现方式
    * *//*
    *//*
    * 查询总记录数
    * *//*
    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id;")
    Long count();

    *//*
    * 分页查询
    * *//*
    @Select("select e.*,d.name deptName " +
            "from emp e left join dept d on e.dept_id = d.id order by e.update_time desc limit #{start},#{pageSize};")
    List<Emp> list(Integer start, Integer pageSize);*/
}
