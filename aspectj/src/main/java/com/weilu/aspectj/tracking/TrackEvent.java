package com.weilu.aspectj.tracking;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TrackEvent {
    /**
     * 事件名称
     */
    String eventName() default "";

    /**
     * 事件id
     */
    String eventId() default "";
}