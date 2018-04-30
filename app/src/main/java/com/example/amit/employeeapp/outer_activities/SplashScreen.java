package com.example.amit.employeeapp.outer_activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.amit.employeeapp.BasicComponentsReuse;
import com.example.amit.employeeapp.MainActivity;
import com.example.amit.employeeapp.R;

public class SplashScreen extends AppCompatActivity {
    public static final String sessionvalue = "Session not created";
    private BasicComponentsReuse basicComponentsReuse_obj=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        //Session shared preference work
        SharedPreferences sharedPreferences_obj = getSharedPreferences("LoginAppSession", Context.MODE_PRIVATE);
        String sessionstatus = sharedPreferences_obj.getString("LoginuserAuthKey", sessionvalue);
        if (sessionstatus.equals(sessionvalue) || sessionstatus.equals("")) {
            final Thread thread_obj = new Thread(
                    new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(1500);
                                Intent intent = new Intent(SplashScreen.this, NumberVerify.class);
                                basicComponentsReuse_obj.intentmoveAnimateCode_method(SplashScreen.this,intent);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }//end of catch
                        }//end of run method7
                    }//end of Runnable
            ); //end of Thread
            thread_obj.start();
        }//end of inner if condition
        else {
            Intent intent_obj = new Intent(getApplicationContext(), MainActivity.class);
            basicComponentsReuse_obj.intentmoveAnimateCode_method(SplashScreen.this,intent_obj);
        }//end of else

    }//end oncreate method

}//end of main class
