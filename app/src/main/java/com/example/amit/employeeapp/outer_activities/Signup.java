package com.example.amit.employeeapp.outer_activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.amit.employeeapp.R;

public class Signup extends AppCompatActivity implements View.OnClickListener{
    Button nextbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        nextbtn=findViewById(R.id.nextbtnid);
        nextbtn.setOnClickListener(this);
    }//end of onCreate method

    @Override
    public void onClick(View view) {
        Intent next_intent=new Intent(Signup.this,NumberVerify.class);
        startActivity(next_intent);
    }//end of onClick method
}//end of main class
