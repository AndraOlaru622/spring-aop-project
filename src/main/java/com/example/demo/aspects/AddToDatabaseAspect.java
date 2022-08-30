package com.example.demo.aspects;

import com.example.demo.model.Driver;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AddToDatabaseAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddToDatabaseAspect.class);

    @Around("execution(* com.example.demo.controller.DriverController.addDriver(..)) && args(dr)")
    public void checkInput(ProceedingJoinPoint joinPoint, Driver dr) {
        LOGGER.info("First Name: " + dr.getFirst_name());
        LOGGER.info("Last Name: " + dr.getLast_name());
        LOGGER.info("Id: " + dr.getId());
        LOGGER.info("Salary: " + dr.getSalary());
        LOGGER.info("Age: " + dr.getAge());
        LOGGER.info("Year of employment: " + dr.getYear_employment());
    }

}
