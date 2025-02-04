package com.example.aopIntro.commons.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect   // necessary for making it an aspect
@Component  // bean
public class Advices {
    // Advice is associated with a pointcut expression
    // Pointcut expr - either inline (in @Before(...)) or a named pointcut (CommonPointcuts...)
    // ( Or we could use ('annotation(...)') )

    @Before("execution(* com.example.aopIntro.dao.*.*(..))")  // INLINE PONTCUT
    public void doAccessCheckInlinePointcut(){
        // code that runs before that method...
    }

    @Before("com.example.aopIntro.commons.aop.CommonPointcuts.dataAccessOperation()") // NAMED POINTCUT
    public void doAccessCheckNamedPointcut() {
        // ...
    }

    @AfterReturning("execution(* com.example.aopIntro.dao.*.*(..))")
    public void doAccessCheckAfterReturning() {
        // ...
    }

    @AfterReturning(
            pointcut="execution(* com.example.aopIntro.dao.*.*(..))",
            returning="retVal")
    public void doAccessCheck(Object retVal) {
        // Run after (proper) returning of method, access return value
        // Name in 'return retVal' MUST be same as returning='...'
        //     Return type must also match
    }

    @AfterThrowing("execution(* com.example.aopIntro.dao.*.*(..))")
    public void doRecoveryActions() {
        // Run after method throws exception
    }

    @AfterThrowing(
            pointcut="execution(* com.example.aopIntro.dao.*.*(..))",
            throwing="ex")
    public void doRecoveryActionsSpecificException(IllegalArgumentException ex) {
        // Run only if specific exception type defined in () is thrown
    }

    @AfterThrowing(
            pointcut="execution(* com.example.aopIntro.dao.*.*(..))",
            throwing="ex")
    public void doRecoveryActionsGetException(Throwable ex) {
        // Run if any exception is thrown, get access to exception
    }

    @After("execution(* com.example.aopIntro.dao.*.*(..))")
    public void doReleaseLock() {
        // Run no matter if method returns correctly or an exception is thrown
    }

    // AROUND
    // Use the least powerful form of advice, do not use Around if not needed
    // Return type must be Object, first param must be ProceedingJoinPoint
    // In body, we must invoke proceed() on ProceedingJoinPoint for the method to run
    //   proceed() without arguments -> original args are supplied to the method
    //   we can use overloaded proceed(Object[]), and the args in [] will be used
    //   proceed() can be called once, many times or not at all
    // Return value -> return value seen by the caller of the method (we may return result of proceed() )
    //   we may return a cache for example
    //   it is recommended to return result of proceed() even if it's void (unless we want to return smth else)

    @Around("execution(* com.example.aopIntro.service.*.*(..))")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
        // start stopwatch
        Object retVal = pjp.proceed();
        // stop stopwatch
        return retVal;
    }

    }
