package com.brillicaservices.studentinfo;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    ArrayList<student> studentClassArrayList = new ArrayList();
    Button btn;
    EditText namevalueTF;
    EditText phoneNumberTF;
    EditText addressNameTF;
    EditText collegeNameTF;
    Button b;
    TextView displayStudentsResultTV;
    String collegeName = "";
    Spinner spinnerCollegeNames;
    AlertDialog.Builder builder;

    /*
    * Creating a string of array of colleges*/
    String collegeNames[] = {"Select college name","DIT", "Graphic Era", "HNB","Dtu","IITD","IITR","DBIT","SGRR","BFIT","TULAS"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        namevalueTF = (EditText) findViewById(R.id.n);
        btn = (Button) findViewById(R.id.button2);
        addressNameTF = (EditText) findViewById(R.id.a);
        phoneNumberTF = (EditText) findViewById(R.id.p);
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

        builder = new AlertDialog.Builder(this);


        btn.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try{

                    String namevalue = namevalueTF.getText().toString();
                    String address = addressNameTF.getText().toString();
                    long phone = Long.parseLong(phoneNumberTF.getText().toString());
                    /* Showing a success message once the data has been saved into arrayList*/
                    if(namevalue.length()>1&&address.length()>1&&phoneNumberTF.length()==10&&!(collegeName.equals(collegeNames[0])))
                    {
                        studentClassArrayList.add(new student(namevalue, address, phone, collegeName));
                        Toast.makeText(getApplicationContext(),
                                "Student data saved successfully",
                                Toast.LENGTH_LONG).show();
                        namevalueTF.setText("");
                        phoneNumberTF.setText("");
                        addressNameTF.setText("");
                        spinnerCollegeNames.setSelection(0);
                    }
                    else if (namevalue.length()<1){
                        builder.setMessage("check your name").setTitle("name error");
                        builder.setPositiveButton("OK",null);
                        AlertDialog dialog = builder.create();
                        dialog.show();

                    }
                  else if (address.length()<1){
                        builder.setMessage("check your address").setTitle("address error");
                        builder.setPositiveButton("OK",null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    else if (phoneNumberTF.length()<10){
                        builder.setMessage("check your phone number").setTitle("Phone number error");
                        builder.setPositiveButton("OK",null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    else if ((collegeName.equals(collegeNames[0]))){
                        builder.setMessage("please enter your college name").setTitle(" college name error");
                        builder.setPositiveButton("OK",null);
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                }
                catch (NumberFormatException e) {
                    builder.setMessage("Enter Your Phone Number Correctly").setTitle("Phone number  error");

//                        builder.setNegativeButton("OK)
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),
                            "check your entries again",
                            Toast.LENGTH_LONG).show();
                }
            }
            });





        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                * Using a for loop to iterate through the list of
                * objects that are stored in the arrayList.*/
                displayStudentsResultTV.setText("");
                for (int i=0; i<studentClassArrayList.size(); i++) {

                    /*
                    * Displaying the results in the displayStudentsResultTV Text View.
                    * get the reference of the value by studentArrayList.get(i) - object stored at current location
                    * .studentName, .studentCollege will give us the value of each variable
                    * in that particular object.*/

                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student Name is: " + studentClassArrayList.get(i).studentName+ "\n");
                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student Phone Number is: " + studentClassArrayList.get(i).ph + "\n");
                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student Address is: " + studentClassArrayList.get(i).addName+ "\n");
                    displayStudentsResultTV.setText(displayStudentsResultTV.getText() +
                            "Student College is: " + studentClassArrayList.get(i).collegeName + "\n");
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

