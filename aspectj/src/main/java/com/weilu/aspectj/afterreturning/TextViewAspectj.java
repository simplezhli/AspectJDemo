package com.weilu.aspectj.afterreturning;

import android.util.Log;
import android.widget.TextView;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;


@Aspect
public class TextViewAspectj {

    @AfterReturning(pointcut = "execution(* *..*.testAfterReturning())", returning = "textView")
    public void getTextView(TextView textView) {
        Log.d("weilu", "text--->" + textView.getText().toString());
    }
}
