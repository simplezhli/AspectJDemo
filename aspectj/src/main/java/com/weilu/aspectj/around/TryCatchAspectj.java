package com.weilu.aspectj.around;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TryCatchAspectj {
    
    @Pointcut("execution(* *..*.testAround())")
    public void methodTryCatch() {
    }

    @Around("methodTryCatch()")
    public void aroundTryJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
       
         try {
             joinPoint.proceed(); // <- 调用原代码
         } catch (Exception e) {
              e.printStackTrace();
         }
    }
}


