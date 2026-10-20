package com.powernode.service;

import com.powernode.pojo.Clazz;
import com.powernode.pojo.ClazzParam;
import com.powernode.pojo.Emp;
import com.powernode.pojo.PageResult;

import java.util.List;

public interface ClazzService {

    PageResult<Clazz> page(ClazzParam clazzParam);

    void delete(Integer id);

    void save(Clazz clazz);

    Clazz getInfo(Integer clazzId);

    void update(Clazz clazz);

    List<Clazz> listAll();
}
