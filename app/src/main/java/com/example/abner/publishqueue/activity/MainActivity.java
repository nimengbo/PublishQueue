package com.example.abner.publishqueue.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.abner.publishqueue.R;

public class MainActivity extends Activity {

    //进入由Service 实现的发布队列
    private Button mServiceButton;

    //进入由Handler 实现的发布队列
    private Button mHanlderButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView(){

        mServiceButton = (Button)findViewById(R.id.publish_queue_by_service);

        mHanlderButton = (Button)findViewById(R.id.publish_queue_by_handler);

    }

    private void initListener(){

        mServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ServiceQueueActivity.class);
                startActivity(intent);
            }
        });

        mHanlderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HandlerQueueActivity.class);
                startActivity(intent);
            }
        });

    }




}
