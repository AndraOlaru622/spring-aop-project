package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DatabaseAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseAspect.class);

    @Pointcut("execution(* *(..)) && @annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.DeleteMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutPostDeleteMappingMethodPointCut() {
    }

    @Pointcut("execution(* *(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void anyRequestMappingMethodPointCut() {
    }

    @AfterReturning(value = "anyRequestMappingMethodPointCut() || anyGetPutPostDeleteMappingMethodPointCut()")
    public void trackDatabaseOperations( JoinPoint joinPoint ) {
        LOGGER.info("****Database Operation");

        String[] operationSignature = (joinPoint.getSignature().toString()).split("\\.", 10);
        String callerFunction = operationSignature[operationSignature.length - 1];
        String callerController = operationSignature[operationSignature.length - 2];

        if(callerController.equals("BasicErrorController")) {
            LOGGER.info("*****Database Operation Error ");
        } else {
            LOGGER.info("*****Caller Controller: " + callerController);
            LOGGER.info("*****Caller Function: " + callerFunction);
        }

    }
}
