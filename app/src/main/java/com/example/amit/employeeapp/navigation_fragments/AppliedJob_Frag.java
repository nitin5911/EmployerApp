package com.example.amit.employeeapp.navigation_fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amit.employeeapp.R;
import com.example.amit.employeeapp.adapterfile.AppliedTabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AppliedJob_Frag extends Fragment implements TabLayout.OnTabSelectedListener {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    private OnFragmentInteractionListener mListener;
    public AppliedJob_Frag() { }

    @BindView(R.id.apldtablayid) TabLayout apldjobtab_obj;
    @BindView(R.id.apldvwpagerid) ViewPager apldjobvwpgr_obj;



    public static AppliedJob_Frag newInstance(String param1, String param2) {
        AppliedJob_Frag fragment = new AppliedJob_Frag();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment; }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2); } }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View apply_view=inflater.inflate(R.layout.fragment_applied_job_, container, false);
        ButterKnife.bind(this,apply_view);
        //Tab layout work
        apldjobtab_obj.addTab(apldjobtab_obj.newTab().setText("Same Day Job"));
        apldjobtab_obj.addTab(apldjobtab_obj.newTab().setText("Booked Job"));
        //Tab Adapter work
        AppliedTabAdapter homeTabAdapter =new AppliedTabAdapter(getActivity().getSupportFragmentManager(),apldjobtab_obj.getTabCount());
        apldjobvwpgr_obj.setAdapter(homeTabAdapter);
        apldjobvwpgr_obj.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(apldjobtab_obj));
        apldjobtab_obj.setOnTabSelectedListener(this);
        return apply_view;
    }//end of onCreateView method

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri); } }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
        //    throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        } }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        apldjobvwpgr_obj.setCurrentItem(tab.getPosition());
    }//end of onTavSelected method
    @Override
    public void onTabUnselected(TabLayout.Tab tab) {}//end of onTabUnselected method
    @Override
    public void onTabReselected(TabLayout.Tab tab) {}//end of onTabReselected method
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }

}//end of main class