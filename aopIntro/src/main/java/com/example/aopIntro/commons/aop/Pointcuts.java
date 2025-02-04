package com.example.aopIntro.commons.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Pointcuts {

    @Pointcut("execution(public  * *(..))")
    public void publicMethod(){}; // any public method

    @Pointcut("within(com.example.aopIntro.trading.*)")
    public void inTrading(){}; // within trading module

    @Pointcut("publicMethod() && inTrading()")
    public void tradingOperation(){}; // public & trading module

    @Before(value = "tradingOperation()")
    public void beforeAspectWithPointcut(){
        // Before aspect functionality
    }
}
