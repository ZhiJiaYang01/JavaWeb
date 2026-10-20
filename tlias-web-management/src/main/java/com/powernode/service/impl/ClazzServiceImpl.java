package com.powernode.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.powernode.mapper.ClazzMapper;
import com.powernode.pojo.Clazz;
import com.powernode.pojo.ClazzParam;
import com.powernode.pojo.Emp;
import com.powernode.pojo.PageResult;
import com.powernode.service.ClazzService;
import com.powernode.utils.PageUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzMapper clazzMapper;

    @Override
    public PageResult<Clazz> page(ClazzParam clazzParam) {
        PageHelper.startPage(clazzParam.getPage(), clazzParam.getPageSize());
        List<Clazz> clazzList = clazzMapper.list(clazzParam);
        // 调用同一个工具方法
        return PageUtil.buildPageResult(clazzList);
    }

    @Override
    public void delete(Integer id) {
        clazzMapper.deleteById(id);
    }

    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.insert(clazz);
    }

    @Override
    public Clazz getInfo(Integer clazzId) {
        return clazzMapper.getInfo(clazzId);
    }

    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public List<Clazz> listAll() {
        return clazzMapper.listAll();
    }

}
