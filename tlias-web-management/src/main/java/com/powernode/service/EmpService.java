package com.powernode.service;

import com.powernode.pojo.Emp;
import com.powernode.pojo.EmpQueryParam;
import com.powernode.pojo.LoginInfo;
import com.powernode.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void save(Emp emp);

    void delete(List<Integer> ids);

    Emp getInfo(Integer id);

    void update(Emp emp);

    LoginInfo login(Emp emp);
}
