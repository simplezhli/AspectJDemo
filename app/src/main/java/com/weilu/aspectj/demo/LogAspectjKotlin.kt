package com.weilu.aspectj.demo

import android.util.Log
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before

@Aspect
class LogAspectjKotlin {
    @Before("execution(* android.app.Activity+.onCreate(..))")
    fun before(joinPoint: JoinPoint) {
        Log.e("weilu", "before")
    }

    @After("execution(* android.app.Activity+.onCreate(..))")
    fun after() {
        Log.e("weilu", "after")
    }
}