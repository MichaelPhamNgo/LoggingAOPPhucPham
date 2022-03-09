package com.bfs.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PointCuts {
    @Pointcut("within(com.bfs.aop.dao.*)")
    public void inDataAccessLayer() {}

    @Pointcut("execution(* com.bfs.aop.dao.*.findAll*(..))")
    public void findAllUser() {}


}
