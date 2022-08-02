package com.turkovaleksey.spring.mvc_aop_hibernate.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution(* com.turkovaleksey.spring.mvc_aop_hibernate.dao.impl.*.*(..))")
    public Object aroundAllRepositoryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        System.out.println("Method " + methodName + " started");
        Object targetMethodResult = proceedingJoinPoint.proceed();
        System.out.println("Method " + methodName + " finished");
        return targetMethodResult;
    }
}
