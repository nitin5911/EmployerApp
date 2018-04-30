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

import com.example.amit.employeeapp.adapterfile.HomeTabAdapter;
import com.example.amit.employeeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Home_frag extends Fragment implements TabLayout.OnTabSelectedListener{

    @BindView(R.id.hometablayid) TabLayout hometab_obj;
    @BindView(R.id.homevwpagerid) ViewPager homevwpgr_obj;

    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    private OnFragmentInteractionListener mListener;
    public Home_frag() {}

    public static Home_frag newInstance(String param1, String param2) {
        Home_frag fragment = new Home_frag();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View home_view=inflater.inflate(R.layout.fragment_home_frag, container, false);
        ButterKnife.bind(this,home_view);
        //Tab layout work
        hometab_obj.addTab(hometab_obj.newTab().setText("Same Day Job"));
        hometab_obj.addTab(hometab_obj.newTab().setText("Booked Job"));
        //Tab Adapter work
        HomeTabAdapter homeTabAdapter =new HomeTabAdapter(getActivity().getSupportFragmentManager(),hometab_obj.getTabCount());
        homevwpgr_obj.setAdapter(homeTabAdapter);
        homevwpgr_obj.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(hometab_obj));
        hometab_obj.setOnTabSelectedListener(this);

        return home_view;
    }//end of onCreateView method

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        } }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
          //  throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        } }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        homevwpgr_obj.setCurrentItem(tab.getPosition());
    }//end of onTabSelected method
    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }//end of onTabUnselected method
    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }//end of onTabReselected method
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
