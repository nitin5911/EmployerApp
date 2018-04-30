package com.example.amit.employeeapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.amit.employeeapp.navigation_fragments.AppliedJob_Frag;
import com.example.amit.employeeapp.navigation_fragments.BookedPost_Frag;
import com.example.amit.employeeapp.navigation_fragments.ChatRoom;
import com.example.amit.employeeapp.navigation_fragments.Feedback_frag;
import com.example.amit.employeeapp.navigation_fragments.Home_frag;
import com.example.amit.employeeapp.navigation_fragments.Profile_frag;
import com.example.amit.employeeapp.navigation_fragments.SamedayPost_Frag;
import com.example.amit.employeeapp.optionmenu_fragments.ChangePassword_frag;
import com.example.amit.employeeapp.outer_activities.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    BasicComponentsReuse basicComponentsReuse_obj=null;
    @BindView(R.id.maintoolbar) Toolbar toolbar_obj;
    @BindView(R.id.maindrawer_layout) DrawerLayout drawer_obj;
    @BindView(R.id.mainnav_view) NavigationView navigationView;
    int backCount=0;
    boolean doublebackpressed = false;
    Handler handler_obj=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        basicComponentsReuse_obj=new BasicComponentsReuse();
        //home fragment replace work
        onNavigationItemCode_method(new Home_frag(),"Posted Jobs","home");
        setSupportActionBar(toolbar_obj);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer_obj, toolbar_obj, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_obj.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }//end of onCreate method

    @Override
    public void onBackPressed() {
        if (drawer_obj.isDrawerOpen(GravityCompat.START))
            drawer_obj.closeDrawer(GravityCompat.START);
        else if(backCount==0)
            onNavigationItemCode_method(new Home_frag(), "Posted Jobs", "home");
        else if(doublebackpressed==true)
            finish();
        else {
            doublebackpressed = true;
            Toast.makeText(this, "Please press Back again to exit", Toast.LENGTH_SHORT).show();
            handler_obj.postDelayed(new Runnable() {
                @Override
                public void run() {
                    doublebackpressed = false;
                }
            }, 3000);
        }
    }//end of onBackPressed method

    public void onNavigationItemCode_method(android.support.v4.app.Fragment fragment, String toolbarname,String fragname){
        backCount=0;
        if(fragname.equalsIgnoreCase("home"))
            backCount=1;
        getSupportFragmentManager().beginTransaction().replace(R.id.maincontainerid,fragment,fragname).commitAllowingStateLoss();
        toolbar_obj.setTitle(toolbarname);
    }//end of onNavigation Item code method

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }//end of onCreateOptionsMenu method

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.changepassid:
                onNavigationItemCode_method(new ChangePassword_frag(),"Change Password","changepass");
                break;
        }//end of switch case
        return super.onOptionsItemSelected(item);
    }//end of onOptionsItemSelected method

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // click navigation view item work.
        switch (item.getItemId()) {
            case R.id.nav_dash:
                onNavigationItemCode_method(new Home_frag(), "Posted Jobs", "home");
                break;
            case R.id.nav_profile:
                onNavigationItemCode_method(new Profile_frag(), "User Profile", "profile");
                break;
            case R.id.nav_sdaypost:
                onNavigationItemCode_method(new SamedayPost_Frag(), "Post SameDay Jobs", "sdaypost");
                break;
            case R.id.nav_bdaypost:
                onNavigationItemCode_method(new BookedPost_Frag(), "Post Booking Jobs", "bdaypost");
                break;
            case R.id.nav_appliedjobs:
                onNavigationItemCode_method(new AppliedJob_Frag(), "Applied Jobs", "appliedjob");
                break;
            case R.id.nav_chat:
                Intent intent = new Intent(MainActivity.this, ChatRoom.class);
                basicComponentsReuse_obj.intentmoveAnimateCode_method(MainActivity.this,intent);
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_feedback:
                onNavigationItemCode_method(new Feedback_frag(), "Give Your Feedback", "feedback");
                break;
            case R.id.nav_logout:
                logout_method();
                break;
        }//end of switch case
        drawer_obj.closeDrawer(GravityCompat.START);
            return true;
    }//end of onNavigationItemSelected method

    private void logout_method() {
        basicComponentsReuse_obj.sharedclear_method(getApplicationContext(),"LoginAppSession");
        Intent logout_intent=new Intent(MainActivity.this,LoginActivity.class);
        basicComponentsReuse_obj.intentmoveAnimateCode_method(MainActivity.this,logout_intent);
    }//end of logout method
}//end of main class