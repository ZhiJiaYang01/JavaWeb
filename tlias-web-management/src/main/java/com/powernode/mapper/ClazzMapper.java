package com.powernode.mapper;

import com.powernode.pojo.Clazz;
import com.powernode.pojo.ClazzParam;
import com.powernode.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClazzMapper {

    List<Clazz> list(ClazzParam clazzParam);

    void deleteById(Integer id);

    void insert(Clazz clazz);

    Clazz getInfo(Integer clazzId);

    void update(Clazz clazz);

    List<Clazz> listAll();
}
