package com.weilu.aspectj.tracking;

import android.util.Log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.json.JSONObject;

import java.lang.annotation.Annotation;

@Aspect
public class TrackEventAspectj {

    @Around("execution(@com.weilu.aspectj.tracking.TrackEvent * *(..))")
    public void trackEvent(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        // 获取方法上的注解
        TrackEvent trackEvent = signature.getMethod().getAnnotation(TrackEvent.class);

        String eventName = trackEvent.eventName();
        String eventId = trackEvent.eventId();

        JSONObject params = new JSONObject();
        params.put("eventName", eventName);
        params.put("eventId", eventId);

        // 获取方法参数的注解
        Annotation[][] parameterAnnotations = signature.getMethod().getParameterAnnotations();

        if (parameterAnnotations.length != 0) {
            int i = 0;
            for (Annotation[] parameterAnnotation : parameterAnnotations) {
                for (Annotation annotation : parameterAnnotation) {
                    if (annotation instanceof TrackParameter) {
                        // 获取key value
                        String key = ((TrackParameter) annotation).value();
                        params.put(key, joinPoint.getArgs()[i++]);
                    }
                }
            }
        }

        // 上报
        Log.e("weilu", "上报数据---->" + params.toString());

        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}


