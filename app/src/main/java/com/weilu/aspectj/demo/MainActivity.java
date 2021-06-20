package com.weilu.aspectj.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.weilu.aspectj.withincode.Person;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test();

        findViewById(R.id.tv).setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.tv) {
            Log.e("weilu", "点击事件执行");
        }
    }
}