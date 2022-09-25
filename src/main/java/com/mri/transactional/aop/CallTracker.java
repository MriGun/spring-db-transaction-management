package com.mri.transactional.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CallTracker {

    @Pointcut("within(com..service.*) || within(com..repo.*) || within(com..dao.*)")
    public void logMethodPointCut() {

    }

    /*@Before("logMethodPointCut()")
    public void LogBeforeMethodCall() {
        System.out.println("method is starting .. ");
    }

    @After("logMethodPointCut()")
    public void LogAfterMethodCall() {
        System.out.println("method execution is complete .. ");
    }*/

    @Around("logMethodPointCut()")
    public Object LogAroundMethodCall(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {


        //proceedingJoinPoint means this method is getting executed.

        //System.out.println("proceedingJoinPoint" + proceedingJoinPoint.toString());
        //String className = proceedingJoinPoint.getSignature().getDeclaringTypeName();
        String methodName = proceedingJoinPoint.getSignature().getName();
        System.out.println("method start :  " + methodName);
        Object returnValue = proceedingJoinPoint.proceed();
        System.out.println("returnValue is : " + returnValue);
        System.out.println("method end :  " +  methodName);
       return returnValue;
    }

}
