package com.aop.springaop.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ServiceAspect {

    @Before("execution(* com.aop.springaop.service.*.*(..))")
    public void beforeSendMessageMethod(@NotNull JoinPoint joinPoint){
        System.out.println("Message received on Service aspect before method, message is : " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

    @After("execution(* com.aop.springaop.service.MessageService.sendMessage(..))")
    public void afterSendMessageMethod(@NotNull JoinPoint joinPoint){
        System.out.println("Message received on Service aspect after method, message is : " + joinPoint.getArgs()[0]);
        System.out.println(joinPoint.getSignature());
    }

}
