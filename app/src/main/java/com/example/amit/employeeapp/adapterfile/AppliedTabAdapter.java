package com.example.amit.employeeapp.adapterfile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.amit.employeeapp.fragments.BKDappliedJobs_frag;
import com.example.amit.employeeapp.fragments.SDappliedJobs_frag;

public class AppliedTabAdapter  extends FragmentStatePagerAdapter {
    private int tabCount;
    public AppliedTabAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount=tabCount;
    }//end of constructor

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new SDappliedJobs_frag();
            case 1: return new BKDappliedJobs_frag();
        }//end of switch case
        return null;
    }//end of getItem method

    @Override
    public int getCount() {
        return tabCount;
    }//end of getCount

}//end of main class
