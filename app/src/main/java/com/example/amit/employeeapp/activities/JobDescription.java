package com.example.amit.employeeapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.amit.employeeapp.BasicComponentsReuse;
import com.example.amit.employeeapp.MainActivity;
import com.example.amit.employeeapp.R;

public class JobDescription extends AppCompatActivity {

    BasicComponentsReuse basicComponentsReuse=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_description);
        basicComponentsReuse=new BasicComponentsReuse();
    }//end of onCreate method

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent jd_intent=new Intent(JobDescription.this, MainActivity.class);
        basicComponentsReuse.intentmoveAnimateCode_method(JobDescription.this,jd_intent);
    }//end of onBackPressed method
}//end of main class
