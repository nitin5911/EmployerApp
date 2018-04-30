package com.example.amit.employeeapp.outer_activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.amit.employeeapp.BasicComponentsReuse;
import com.example.amit.employeeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;

public class NumberVerify extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {

    @BindView(R.id.countryspinnerid) Spinner spinner_obj;
    @BindView(R.id.etxtphonenoid) EditText editText_obj;
    @BindView(R.id.sendotpbtnid) Button verifybtn;
    private static final String[] country_spin = {"Choose a country","USA (+64)","Australia (+61)","India (+91)"};
    private BasicComponentsReuse basicComponentsReuse_obj=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_verify);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        // bind the view using butterknife
        ButterKnife.bind(this);
        //spinner work
        basicComponentsReuse_obj.showStaticSpinner_method(NumberVerify.this,country_spin,spinner_obj,0);
        spinner_obj.setOnItemSelectedListener(this);
    }//end of onCreate method

    @OnClick(R.id.sendotpbtnid)
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(NumberVerify.this, SubmitOTP.class);
        basicComponentsReuse_obj.intentmoveAnimateCode_method(NumberVerify.this,intent);
    }//end of onClick method

    @OnItemSelected(R.id.countryspinnerid)
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i>0) spinner_obj.setSelection(i);
        else spinner_obj.setSelection(0);
    }//end of onItemSelected method

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {}//end of onNothingSelected method

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(NumberVerify.this, LoginActivity.class);
        basicComponentsReuse_obj.intentmoveAnimateCode_method(NumberVerify.this,intent);
    }//end of onBackPressed method
}//end of main class