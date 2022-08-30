package com.example.demo.aspects.interceptorAspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RepositoryInterceptorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(RepositoryInterceptorAspect.class);

    @Pointcut("execution(* com.example.demo.repository.*.*(..))")
    public void repositoryLoggingPoint() {}

    @Before("repositoryLoggingPoint()")
    public void before( JoinPoint joinPoint ) {

        String[] operationSignature = (joinPoint.getSignature().toString()).split("\\.", 10);
        LOGGER.info("Before Repository: " + operationSignature[operationSignature.length - 2]);

    }

    @After("repositoryLoggingPoint()")
    public void after( JoinPoint joinPoint ) {

        String[] operationSignature = (joinPoint.getSignature().toString()).split("\\.", 10);
        LOGGER.info("After Repository: " + operationSignature[operationSignature.length - 2]);

    }
}
