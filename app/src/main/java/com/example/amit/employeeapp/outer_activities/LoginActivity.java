package com.example.amit.employeeapp.outer_activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.amit.employeeapp.BasicComponentsReuse;
import com.example.amit.employeeapp.R;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindViews({R.id.fbloginbtnid,R.id.gploginbtnid}) List<ImageButton> button_obj;
    private BasicComponentsReuse basicComponentsReuse_obj=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        // bind the view using butterknife
        ButterKnife.bind(this);
    }//end of onCreate method

    @OnClick({R.id.fbloginbtnid,R.id.gploginbtnid})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fbloginbtnid:
                Intent fbintent = new Intent(LoginActivity.this, NumberVerify.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(LoginActivity.this, fbintent);
                break;
            case R.id.gploginbtnid:
                Intent gpintent = new Intent(LoginActivity.this, NumberVerify.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(LoginActivity.this, gpintent);
                break;
        }//end of switch case method
        }//end of onClick method

    @Override
    public void onBackPressed() {
        finish();
    }//end of onBackPressed method
}//end of main class
