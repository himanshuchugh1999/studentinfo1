package com.brillicaservices.studentinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by HIMANSHU CHUGH on 03-07-2018.
 */

public class student extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studentinf);
        textView1 = (TextView) findViewById(R.id.text);
        textView1.setText(" name is  :" + getIntent().getStringExtra("NAME"));
        textView2 = (TextView) findViewById(R.id.t);
        textView2.setText(" address is  :" + getIntent().getStringExtra("ADDRESS"));
        textView3 = (TextView) findViewById(R.id.tex);
        textView3.setText(" college is  :" + getIntent().getStringExtra("COLLEGE"));
        textView4 = (TextView) findViewById(R.id.te);
        textView4.setText(" phonnenumber :" + getIntent().getStringExtra("PHONE"));
    }}