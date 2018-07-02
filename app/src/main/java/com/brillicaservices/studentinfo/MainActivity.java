package com.brillicaservices.studentinfo;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<student> studentClassArrayList = new ArrayList();
    Button btn;
    EditText nn;
    EditText pp;
    EditText aa;
    EditText cc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nn = (EditText) findViewById(R.id.n);
        btn = (Button) findViewById(R.id.button);
        aa = (EditText) findViewById(R.id.a);
        pp = (EditText) findViewById(R.id.p);
        cc = (EditText) findViewById(R.id.c);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String namevalue = nn.getText().toString();
                String address = aa.getText().toString();
                long phone = Long.parseLong(pp.getText().toString());
                String college = cc.getText().toString();
                Intent intent = new Intent(MainActivity.this, student.class);
                intent.putExtra("NAME", namevalue);
                intent.putExtra("ADDRESS", address);
                intent.putExtra("PHONE", phone);
                intent.putExtra("COLLEGE", college);

                startActivity(intent);
            }

        });

    }}