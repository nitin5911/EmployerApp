package com.example.amit.employeeapp.outer_activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amit.employeeapp.BasicComponentsReuse;
import com.example.amit.employeeapp.MainActivity;
import com.example.amit.employeeapp.R;
import com.goodiebag.pinview.Pinview;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SubmitOTP extends AppCompatActivity implements View.OnClickListener{

    @BindView(R.id.loginpinviewid) Pinview pinview_obj;
    @BindView(R.id.otpsubmitbtnid) Button submitbtn;
    @BindViews({R.id.otpexprtextid,R.id.resendtextid}) List<TextView> textViews_obj;
    private BasicComponentsReuse basicComponentsReuse_obj=null;
    ArrayList<String> login_arraylist=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_otp);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        // bind the view using butterknife
        ButterKnife.bind(this);
    }//end of onCreate method

    @OnClick({R.id.otpsubmitbtnid,R.id.otpexprtextid,R.id.resendtextid})
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.otpsubmitbtnid:
                basicComponentsReuse_obj.mainAppSessioncreate_method(getApplicationContext(),"LoginAppSession","LoginuserAuthKey","hj74g43vdu64454","Loginuserdetaillist",login_arraylist);
                Intent intent = new Intent(SubmitOTP.this, MainActivity.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(SubmitOTP.this,intent);
                break;
            case R.id.resendtextid:
                Toast.makeText(this, "resend otp calling", Toast.LENGTH_SHORT).show();
                break;
        }//end of switch case
    }//end of onClick method

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SubmitOTP.this, NumberVerify.class);
        basicComponentsReuse_obj.intentmoveAnimateCode_method(SubmitOTP.this,intent);
    }//end of onBackPressed method

}//end of main class