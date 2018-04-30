package com.example.amit.employeeapp.activities;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.amit.employeeapp.BasicComponentsReuse;
import com.example.amit.employeeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AppliedJobDescription extends AppCompatActivity implements View.OnClickListener{
    @BindView(R.id.ajdtracktxtid) TextView textView_obj;
    BasicComponentsReuse basicComponentsReuse=null;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_applied_job_description);
        ButterKnife.bind(this);
        basicComponentsReuse = new BasicComponentsReuse();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            checkLocationPermission();

    }//end of onCreate method

    //  Here give the permission to access the map location
    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)!= PackageManager.PERMISSION_GRANTED){
            // Should we show an explanation
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)&& ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_COARSE_LOCATION)) {
                new AlertDialog.Builder(this).setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                ActivityCompat.requestPermissions(AppliedJobDescription.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                                ActivityCompat.requestPermissions(AppliedJobDescription.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                            }
                        }).create().show();
            } else
            {
                ActivityCompat.requestPermissions(AppliedJobDescription.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
                ActivityCompat.requestPermissions(AppliedJobDescription.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }
        }
    }//end of checkLocationPermission method

    @OnClick(R.id.ajdtracktxtid)
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ajdtracktxtid:
                Intent jd_intent=new Intent(AppliedJobDescription.this, TrackingPathMap.class);
                basicComponentsReuse.intentmoveAnimateCode_method(AppliedJobDescription.this,jd_intent);
                break;
        }//end of switch case
    }//end of onClick method

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        }//end of onBackPressed method
}//end of main class
