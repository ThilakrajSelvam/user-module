package com.playground.usermodule.aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author thilak
 * @created 12/9/20
 */
@Aspect
@Component
@Slf4j
public class ExecutionTimeLoggerAspect {

    @Around("@annotation(com.playground.usermodule.aop.annotation.ExecutionTimeLogger)")
    public Object logExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        log.info("{} method executed in {} ms", proceedingJoinPoint.getSignature().getName(), executionTime);
        return proceed;
    }
}
