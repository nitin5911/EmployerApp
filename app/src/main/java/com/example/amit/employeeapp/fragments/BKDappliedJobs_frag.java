package com.example.amit.employeeapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amit.employeeapp.adapterfile.BKDApldRecyclerAdapter;
import com.example.amit.employeeapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BKDappliedJobs_frag extends Fragment {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    private OnFragmentInteractionListener mListener;

    @BindView(R.id.bkdajobsrecyid) RecyclerView bkdajrecyclerView_obj;
    RecyclerView.LayoutManager bkdajobs_lmngr;
    ArrayList<String> bkdajobs_arraylist=new ArrayList<>();


    public BKDappliedJobs_frag() {}
    public static BKDappliedJobs_frag newInstance(String param1, String param2) {
        BKDappliedJobs_frag fragment = new BKDappliedJobs_frag();
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
        View bkda_view= inflater.inflate(R.layout.fragment_bkdapplied_jobs_frag, container, false);
        ButterKnife.bind(this,bkda_view);
        //RecyclerView Work
        bkdajrecyclerView_obj.setHasFixedSize(true);
        bkdajobs_lmngr=new LinearLayoutManager(getActivity());
        bkdajrecyclerView_obj.setLayoutManager(bkdajobs_lmngr);
        bkdajobs_arraylist.add("First Job");
        bkdajobs_arraylist.add("Second Job");
        bkdajobs_arraylist.add("Third Job");
        bkdajobs_arraylist.add("Fourth Job");
        //RecyclerView Adapter work
        BKDApldRecyclerAdapter recycleradapter =new BKDApldRecyclerAdapter(getActivity(),bkdajobs_arraylist);
        bkdajrecyclerView_obj.setAdapter(recycleradapter);
        return bkda_view;
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
       //     throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        } }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
