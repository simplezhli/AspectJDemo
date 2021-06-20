package com.weilu.aspectj.click;


import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class InterceptClickAspectJ {

    // 最后一次点击的时间
    private Long lastTime = 0L;
    // 点击间隔时长
    private static final Long INTERVAL = 300L;

    @Around("execution(* android.view.View.OnClickListener.onClick(..))")
    public void clickIntercept(ProceedingJoinPoint joinPoint) throws Throwable {
        // 大于间隔时间可点击
        if (System.currentTimeMillis() - lastTime >= INTERVAL) {
            // 记录点击时间
            lastTime = System.currentTimeMillis();
            // 执行点击事件
            joinPoint.proceed();
        } else {
            Log.e("weilu", "重复点击");
        }
    }

    @Around("execution(* *..lambda$*(android.view.View))")
    public void clickInterceptLambda(ProceedingJoinPoint joinPoint) throws Throwable {
        // 大于间隔时间可点击
        if (System.currentTimeMillis() - lastTime >= INTERVAL) {
            // 记录点击时间
            lastTime = System.currentTimeMillis();
            // 执行点击事件
            joinPoint.proceed();
        } else {
            Log.e("weilu", "重复点击");
        }
    }
}
