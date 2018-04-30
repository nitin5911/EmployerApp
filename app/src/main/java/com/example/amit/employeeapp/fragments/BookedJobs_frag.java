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

import com.example.amit.employeeapp.adapterfile.BkdayRecyclerAdapter;
import com.example.amit.employeeapp.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookedJobs_frag extends Fragment {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    private OnFragmentInteractionListener mListener;
    public BookedJobs_frag() { }

    @BindView(R.id.bkdjobsrecyid) RecyclerView bkdjrecyclerView_obj;
    RecyclerView.LayoutManager bkdjobs_lmngr;
    ArrayList<String> bkdjobs_arraylist=new ArrayList<>();

    public static BookedJobs_frag newInstance(String param1, String param2) {
        BookedJobs_frag fragment = new BookedJobs_frag();
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
        View bjobs_view= inflater.inflate(R.layout.fragment_booked_jobs_frag, container, false);
        ButterKnife.bind(this,bjobs_view);
        //RecyclerView Work
        bkdjrecyclerView_obj.setHasFixedSize(true);
        bkdjobs_lmngr=new LinearLayoutManager(getActivity());
        bkdjrecyclerView_obj.setLayoutManager(bkdjobs_lmngr);
        bkdjobs_arraylist.add("First Job");
        bkdjobs_arraylist.add("Second Job");
        bkdjobs_arraylist.add("Third Job");
        bkdjobs_arraylist.add("Fourth Job");
        //RecyclerView Adapter work
        BkdayRecyclerAdapter recycleradapter =new BkdayRecyclerAdapter(getActivity(),bkdjobs_arraylist);
        bkdjrecyclerView_obj.setAdapter(recycleradapter);
        return bjobs_view;
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
          //  throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        } }
    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null; }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri); }
}//end of main class
