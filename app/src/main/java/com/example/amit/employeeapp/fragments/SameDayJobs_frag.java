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

import com.example.amit.employeeapp.R;
import com.example.amit.employeeapp.adapterfile.SdayRecyclerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SameDayJobs_frag extends Fragment {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    private OnFragmentInteractionListener mListener;

    @BindView(R.id.sdjobsrecyid) RecyclerView sdjrecyclerView_obj;
    RecyclerView.LayoutManager sdjobs_lmngr;
    ArrayList<String> sdjobs_arraylist=new ArrayList<>();

    public SameDayJobs_frag() { }
    public static SameDayJobs_frag newInstance(String param1, String param2) {
        SameDayJobs_frag fragment = new SameDayJobs_frag();
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
        View samejobs_view=inflater.inflate(R.layout.fragment_same_day_jobs_frag, container, false);
        ButterKnife.bind(this,samejobs_view);
        //RecyclerView Work
        sdjrecyclerView_obj.setHasFixedSize(true);
        sdjobs_lmngr=new LinearLayoutManager(getActivity());
        sdjrecyclerView_obj.setLayoutManager(sdjobs_lmngr);
        sdjobs_arraylist.add("First Job");
        sdjobs_arraylist.add("Second Job");
        sdjobs_arraylist.add("Third Job");
        sdjobs_arraylist.add("Fourth Job");
        //RecyclerView Adapter work
        SdayRecyclerAdapter recycleradapter =new SdayRecyclerAdapter(getActivity(),sdjobs_arraylist);
        sdjrecyclerView_obj.setAdapter(recycleradapter);
        return samejobs_view;
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
      //      throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        } }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
