package com.brillicaservices.studentinfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<student> studentClassArrayList = new ArrayList();
    Button btn;
    EditText nn;
    EditText pp;
    EditText aa;
    EditText cc;
    Button b;
    TextView displayStudentsResultTV;
    String collegeName = "";
    Spinner spinnerCollegeNames;

    /*
    * Creating a string of array of colleges*/
    String collegeNames[] = {"Select college name","DIT", "Graphic Era", "HNB"};
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

        spinnerCollegeNames = findViewById(R.id.college_id_spinner);

        /*
        * Using setOnItemSelectedListener on spinner object
        * and giving it the context - this, meaning current activity*/
        spinnerCollegeNames.setOnItemSelectedListener(this);

        /*
        * Creating an arrayAdapter object and passing 3 different arguments
        * i.e. context, layout, array*/
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, collegeNames);

        /*
        * using the spinner's setAdapter method to update it's adapter*/
        spinnerCollegeNames.setAdapter(arrayAdapter);

        /*
        * setPrompt is select on spinner to just give the refernce that the
        * first object of array is only a label.*/
        spinnerCollegeNames.setPrompt(collegeNames[0]);

        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                String namevalue = nn.getText().toString();
                String address = aa.getText().toString();
                long phone = Long.parseLong(pp.getText().toString());
                String college = cc.getText().toString();
                boolean add = studentClassArrayList.add(new student(namevalue, address, phone, collegeName));
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

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        /*
        * getting college name from the list of colleges.
        * It will be updated only on the basis of array.*/
        collegeName = collegeNames[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

