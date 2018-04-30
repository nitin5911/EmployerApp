package com.example.amit.employeeapp.adapterfile;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.amit.employeeapp.R;

import java.util.ArrayList;

/**
 * Created by reax on 12/1/18.
 */

public class SpinnerAdapterfile extends BaseAdapter{

    Context context;
    String[] spinnerarray;
    ArrayList<String> arrayListDist;
    LayoutInflater inflter;
    int var=0;

    public SpinnerAdapterfile(FragmentActivity activity, ArrayList<String> spinnerarray, int i) {
        context = activity;
        var=i;
        arrayListDist = spinnerarray;
        inflter = (LayoutInflater.from(activity));
    }//end of constructor
    public SpinnerAdapterfile(Context activity, String[] spinnerarray) {
        context = activity;
        this.spinnerarray = spinnerarray;
        inflter = (LayoutInflater.from(activity));
    }//end of constructor

    @Override
    public int getCount() {
        if (var==1)return arrayListDist.size();
        return spinnerarray.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.spinnerboxdesign, null);
        TextView names =view.findViewById(R.id.spinnertextid);
        if(var==1) names.setText(arrayListDist.get(i));
        else names.setText(spinnerarray[i]);
        return view;
    }
}//end of main class

