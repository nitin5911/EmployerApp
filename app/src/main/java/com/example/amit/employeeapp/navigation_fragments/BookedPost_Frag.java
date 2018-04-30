package com.example.amit.employeeapp.navigation_fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.amit.employeeapp.R;

public class BookedPost_Frag extends Fragment {
    private static final String ARG_PARAM1 = "param1",ARG_PARAM2 = "param2";
    private String mParam1,mParam2;
    private OnFragmentInteractionListener mListener;
    public BookedPost_Frag() {}

    public static BookedPost_Frag newInstance(String param1, String param2) {
        BookedPost_Frag fragment = new BookedPost_Frag();
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
        View bday_view=inflater.inflate(R.layout.fragment_booked_post_, container, false);
        return bday_view;
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