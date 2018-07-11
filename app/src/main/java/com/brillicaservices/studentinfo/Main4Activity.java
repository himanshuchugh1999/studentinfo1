package com.brillicaservices.studentinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by HIMANSHU CHUGH on 08-07-2018.
 */

public class Main4Activity extends AppCompatActivity {
    Button signin;
    EditText nameidEV,passidEV;
    DatabaseHelper db;

    @Override
   public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity1);
        nameidEV = (EditText) findViewById(R.id.nameid);
       passidEV = (EditText) findViewById(R.id.passid);
        signin=(Button) findViewById(R.id.sign);
        db=new DatabaseHelper((this));
        signin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String nameidValue=nameidEV.getText().toString();
                String passidValue=passidEV.getText().toString();
                if(nameidValue.equals("")||passidValue.equals("")){
                    Toast.makeText(getApplicationContext(),
                            "Fields are empty",
                            Toast.LENGTH_LONG).show();
                }
                else
                {
                    boolean check=db.name(nameidValue,passidValue);
                    if(check == true) {
                        Intent intent2 = new Intent(
                                Main4Activity.this,
                                Main3Activity.class);
                        startActivity(intent2);
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid login", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
