package com.example.amit.employeeapp.adapterfile;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.amit.employeeapp.fragments.BookedJobs_frag;
import com.example.amit.employeeapp.fragments.SameDayJobs_frag;

public class HomeTabAdapter extends FragmentStatePagerAdapter {
    private int tabCount;
    public HomeTabAdapter(FragmentManager fm, int tabCount){
        super(fm);
        this.tabCount=tabCount;
    }//end of constructor

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new SameDayJobs_frag();
            case 1: return new BookedJobs_frag();
        }//end of switch case
        return null;
    }//end of getItem method

    @Override
    public int getCount() {
        return tabCount;
    }//end of getCount
}//end of hometabAdapter
