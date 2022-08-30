package com.example.demo.aspects.interceptorAspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
@Component
public class ServiceInterceptorAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceInterceptorAspect.class);

    @Pointcut("execution(* com.example.demo.service.*.*(..))")
    public void serviceLoggingPoint() {}

    @Before("serviceLoggingPoint()")
    public void before( JoinPoint joinPoint ) {

        String[] operationSignature = (joinPoint.getSignature().toString()).split("\\.", 10);
        LOGGER.info("Before Service: " + operationSignature[operationSignature.length - 2]);

    }

    @After("serviceLoggingPoint()")
    public void after( JoinPoint joinPoint ) {

        String[] operationSignature = (joinPoint.getSignature().toString()).split("\\.", 10);
        LOGGER.info("After Service:  " + operationSignature[operationSignature.length - 2]);

    }
}
