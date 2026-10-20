package com.powernode.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class RecordTimeAspect {

    @Around("execution(* com.powernode.service.*.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        //1.记录方法开始执行时间
        long startTime = System.currentTimeMillis();
        log.info("方法执行开始时间:{}", startTime);

        //2.执行原始方法
        Object result = pjp.proceed();

        //3.记录方法执行结束时间
        long endTime = System.currentTimeMillis();
        log.info("方法执行结束时间:{}", endTime);

        //4.计算方法执行时间
        long costTime = endTime - startTime;
        log.info("方法 {} 执行时间:{} ms", pjp.getSignature(), costTime);

        return result;
    }
}
