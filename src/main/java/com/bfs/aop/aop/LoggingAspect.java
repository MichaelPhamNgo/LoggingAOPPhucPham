package com.bfs.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    //Save a string data access layer before advice. This step happens after accessing the controller
    @Before("com.bfs.aop.aop.PointCuts.inDataAccessLayer()")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Data Access Layer Before Advice");
        logger.info("" + joinPoint.getSignature());
    }

    //Print execution in advice
    @Around("com.bfs.aop.aop.PointCuts.inDataAccessLayer()")
    public Object executionTimeAdvice(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = pjp.proceed();
        long elapsedTime = System.currentTimeMillis() - startTime;
        logger.info("The DAO layer execution time is : " + elapsedTime + " ms");
        logger.info("return age: "+result.toString());
        return result;
    }

    //Save a string data access layer after advice.
    @After("com.bfs.aop.aop.PointCuts.inDataAccessLayer()")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("Data Access Layer After Advice");
        logger.info("" + joinPoint.getSignature());
    }


    @AfterReturning(value = "bean(testDao)", returning = "res")
    public void afterReturningAdvice(Object res){
        logger.info("Data Access After Returning Advice ");
        logger.info("The return age is "+res.toString());
    }

    @AfterThrowing(value = "bean(testDao)", throwing = "ex")
    public void afterThrowingAdvice(Exception ex){
        logger.info("Data Access After Throwing ");
        logger.error(ex.toString());
    }

    @Before("com.bfs.aop.aop.PointCuts.findAllUser()")
    public void beforeAdvice(){
        logger.info("Before getting all users.");
    }

    @After("com.bfs.aop.aop.PointCuts.findAllUser()")
    public void afterAdvice(){
        logger.info("After getting all users.");
    }
}
