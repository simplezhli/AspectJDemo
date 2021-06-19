package com.weilu.aspectj.withincode;


import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class FieldAspectJ {

    @Pointcut("!withincode(com.weilu.aspectj.demo.Person.new())")
    public void invokePerson() {
    }

    @Around("set(int com.weilu.aspectj.demo.Person.age) && invokePerson()")
    public void aroundFieldSet(ProceedingJoinPoint joinPoint) throws Throwable {
        Log.e("weilu", "around->" + joinPoint.getTarget().toString() + "#" + joinPoint.getSignature().getName());
    }
}
