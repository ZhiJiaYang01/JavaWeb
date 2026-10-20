package com.powernode.aop;

import com.powernode.mapper.OperateLogMapper;
import com.powernode.pojo.OperateLog;
import com.powernode.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect //切面类
public class OperateLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    //环绕通知：切点 = com.itheima.controller包下，加了@Log注解的方法
    @Around("@annotation(com.powernode.anno.Log)")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {

        //1. 记录方法开始执行时间
        long start = System.currentTimeMillis();

        //执行目标方法
        Object result = joinPoint.proceed();

        //计算耗时
        long end = System.currentTimeMillis();
        long costTime = end - start;

        //获取方法签名
        Signature signature = joinPoint.getSignature();

        //构建日志实体
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentUserId()); // 操作人ID：从登录上下文获取
        operateLog.setOperateTime(LocalDateTime.now()); // 操作时间
        operateLog.setClassName(signature.getClass().getName()); // 目标类全类名
        operateLog.setMethodName(signature.getName()); // 目标方法名
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs())); // 方法运行参数
        operateLog.setReturnValue(result!=null?result.toString():"void"); // 方法返回值
        operateLog.setCostTime(costTime); // 执行耗时


        operateLogMapper.insert(operateLog);
        log.info("操作日志已保存");

        //返回目标方法的返回结果
        return result;
    }

    private Integer getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}
