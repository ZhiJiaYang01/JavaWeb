package com.powernode.mapper;

import com.powernode.pojo.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpLogMapper {

    void insert(EmpLog empLog);
}
