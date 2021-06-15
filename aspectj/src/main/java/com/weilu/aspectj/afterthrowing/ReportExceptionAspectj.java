package com.weilu.aspectj.afterthrowing;

import android.util.Log;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class ReportExceptionAspectj {

    @AfterThrowing(pointcut = "call(* *..*.testAfterThrowing())", throwing = "throwable")  // "throwable"必须和下面参数名称一样
    public void reportException(Throwable throwable) {
        Log.e("weilu", "throwable--->" + throwable);
    }
}
