package com.weilu.aspectj.afterbefore;

import android.os.Trace;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;


@Aspect
public class TraceTagAspectj {

    @Before("execution(* android.app.Activity+.onCreate(..))")
    public void before(JoinPoint joinPoint) {
        Trace.beginSection(joinPoint.getSignature().toString());
    }

    @After("execution(* android.app.Activity+.onCreate(..))")
    public void after() {
        Trace.endSection();
    }
}
