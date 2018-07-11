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
    int id;
    String passwords;

    public student(int id, String studentName, String collegeName, long ph, String addName, String passwords) {
        this.id = id;
        this.studentName = studentName;
        this.collegeName = collegeName;
        this.addName = addName;
        this.ph = ph;
        this.passwords = passwords;
    }

    public student(String studentName, String collegeName, String addName, long ph, String passwords) {
        this.id = id;
        this.studentName = studentName;
        this.collegeName = collegeName;
        this.addName = addName;
        this.ph = ph;
        this.passwords = passwords;
    }

    public student() {

    }

    public long getPhoneNumber() {
        return ph;
    }

    public String getAddress() {
        return addName;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getName() {
        return studentName;
    }

    public int getId() {
        return id;
    }
    public String getPasswords(){
        return passwords;
    }

    public void setAddress(String address) {
        this.addName = address;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public void setName(String name) {
        this.studentName = name;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.ph = phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setPasswords(String passwords) {
        this.passwords=passwords;
    }
}





