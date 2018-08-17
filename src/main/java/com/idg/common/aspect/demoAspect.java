package com.idg.common.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author xiongchenyang
 * @version [1.0 , 2018/8/16]
 */
@Aspect
@Component
public class demoAspect {

    @Before("execution(* com.idg.demo.service.DemoServiceImpl.testTx(..))")
    public void before(){
        System.out.println("接口执行前，发起操作：before...");
    }

    @After("execution(* com.idg.demo.service.DemoServiceImpl.testTx(..))")
    public void after(){
        System.out.println("接口执行后，发起操作：after...");
    }

    @AfterReturning("execution(* com.idg.demo.service.DemoServiceImpl.testTx(..))")
    public void afterReturning(){
        System.out.println("接口返回后，发起操作： afterReturning...");
    }

    @AfterThrowing("execution(* com.idg.demo.service.DemoServiceImpl.testTx(..))")
    public void afterThrowing(){
        System.out.println("接口异常后，发起操作： afterThrowing...");
    }

    @Pointcut("execution(* com.idg.demo.service.DemoServiceImpl.testTx(..))")
    public void cut(){

    }

    @Around("cut()")
    public Integer around(ProceedingJoinPoint pjp){
        System.out.println("接口前后都要执行，发起操作： aroundbefore...");
        try {
            pjp.proceed();
            System.out.println("接口前后都要执行，发起操作： aroundAfter...");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        return 1;
    }

}  
