package com.brillicaservices.studentinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by HIMANSHU CHUGH on 03-07-2018.
 */

public class student extends AppCompatActivity {
    String studentName;
    String collegeName;
    String addName;
    long ph;


    public student(String sname,String addressName,long phoneNumber,String collName){
        studentName=sname;
        collegeName=collName;
        ph=phoneNumber;
        addName=addressName;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }}







