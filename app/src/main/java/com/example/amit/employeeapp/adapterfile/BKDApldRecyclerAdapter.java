package com.example.amit.employeeapp.adapterfile;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.amit.employeeapp.BasicComponentsReuse;
import com.example.amit.employeeapp.R;
import com.example.amit.employeeapp.activities.AppliedJobDescription;

import java.util.ArrayList;

public class BKDApldRecyclerAdapter extends RecyclerView.Adapter<BKDApldRecyclerAdapter.BKdaViewholder> {

    ArrayList<String> bkajobs_arraylist=new ArrayList<>();
    Context context;
    BasicComponentsReuse basicComponentsReuse=new BasicComponentsReuse();
    public BKDApldRecyclerAdapter(Context context, ArrayList<String> bkajobs_arraylist) {
        this.bkajobs_arraylist=bkajobs_arraylist;
        this.context=context;
    }//end of constructor
    @Override
    public BKdaViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View bkajobs_obj = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookedjobscard, parent, false);
        return new BKdaViewholder(bkajobs_obj);
    }//end of onCreateViewHolder method
    @Override
    public void onBindViewHolder(BKdaViewholder holder, int position) {
        holder.title_txt.setText(bkajobs_arraylist.get(position));
    }//end of onBindViewHolder method
    @Override
    public int getItemCount() {
        return bkajobs_arraylist.size();
    }//end of getItemCount method

    public class BKdaViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView_obj;
        TextView title_txt;
        public BKdaViewholder(View itemView) {
            super(itemView);
            title_txt=itemView.findViewById(R.id.bkdjjobtitleid);
            cardView_obj=itemView.findViewById(R.id.bkdjcardviewid);
            cardView_obj.setOnClickListener(this);
        }//end of constructor
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.bkdjcardviewid:
                    Intent job_intent=new Intent(itemView.getContext(),AppliedJobDescription.class);
                    basicComponentsReuse.intentmoveAnimateCode_method(itemView.getContext(),job_intent);
                    break;
            }//end of switch case
        }//end of onClick method
    }//end of viewholder class
}//end of main class
