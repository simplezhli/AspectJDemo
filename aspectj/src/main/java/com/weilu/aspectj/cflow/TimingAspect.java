package com.weilu.aspectj.cflow;


import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import static java.lang.System.currentTimeMillis;

@Aspect
public class TimingAspect {

    @Around("execution(* *(..)) && cflow(execution(* com.weilu.aspectj.demo.MainActivity.test(..)))")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = currentTimeMillis();
        Log.e("weilu", joinPoint.getSignature().toString() + " -> " + (endTime - startTime) + " ms");
        return result;
    }

}