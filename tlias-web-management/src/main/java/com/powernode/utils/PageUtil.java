package com.powernode.utils;

import com.github.pagehelper.Page;
import com.powernode.pojo.PageResult;

import java.util.List;

public class PageUtil {

    /**
     * PageHelper分页结果转PageResult
     * @param list PageHelper返回的list（实际是Page对象）
     * @return 分页结果
     */
    public static <T> PageResult<T> buildPageResult(List<T> list) {
        Page<T> page = (Page<T>) list;
        return new PageResult<>(page.getTotal(), page.getResult());
    }
}
