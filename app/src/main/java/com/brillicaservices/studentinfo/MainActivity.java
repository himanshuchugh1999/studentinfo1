package com.brillicaservices.studentinfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<student> studentClassArrayList = new ArrayList();
    Button btn;
    EditText nn;
    EditText pp;
    EditText aa;
    EditText cc;
    Button b;
    TextView displayStudentsResultTV;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nn = (EditText) findViewById(R.id.n);
        btn = (Button) findViewById(R.id.button2);
        aa = (EditText) findViewById(R.id.a);
        pp = (EditText) findViewById(R.id.p);
        cc = (EditText) findViewById(R.id.c);
        b=(Button) findViewById(R.id.button);
        displayStudentsResultTV = findViewById(R.id.textView);
        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String namevalue = nn.getText().toString();
                String address = aa.getText().toString();
                long phone = Long.parseLong(pp.getText().toString());
                String college = cc.getText().toString();
                boolean add = studentClassArrayList.add(new student(namevalue, address, phone, college));
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                * Using a for loop to iterate through the list of
                * objects that are stored in the arrayList.*/
                for (int i=0; i<studentClassArrayList.size(); i++) {

                    /*
                    * Displaying the results in the displayStudentsResultTV Text View.
                    * get the reference of the value by studentArrayList.get(i) - object stored at current location
                    * .studentName, .studentCollege will give us the value of each variable
                    * in that particular object.*/

                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student Name is: " + studentClassArrayList.get(i).studentName+ "\n");
                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student College is: " + studentClassArrayList.get(i).collegeName + "\n");
                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student Phone Number is: " + studentClassArrayList.get(i).ph + "\n");
                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student Address is: " + studentClassArrayList.get(i).addName+ "\n");
                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() + "****************\n\n");
                }
            }
        });

    }

    }

