package com.weilu.aspectj.demo;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.weilu.aspectj.withincode.Person;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();
    }

    private void test() {
//        testAfterThrowing();
        testAfterReturning();
        testAround();

        Person person = new Person();
        person.setAge(100);
        Log.e("weilu", "age--->" + person.getAge());
    }

    private void testAfterThrowing() {
        TextView textView = null;
        textView.setText("testAfterThrowing");
    }

    private TextView testAfterReturning() {
        return findViewById(R.id.tv);
    }

    private void testAround() {
        TextView textView = null;
        textView.setText("testAround");
    }
}