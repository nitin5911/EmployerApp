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
import com.example.amit.employeeapp.activities.JobDescription;
import com.example.amit.employeeapp.R;

import java.util.ArrayList;

public class SdayRecyclerAdapter extends RecyclerView.Adapter<SdayRecyclerAdapter.SdayViewholder> {

    ArrayList<String> sdjobs_arraylist=new ArrayList<>();
    Context context;
    BasicComponentsReuse basicComponentsReuse=new BasicComponentsReuse();

    public SdayRecyclerAdapter(Context context, ArrayList<String> sdjobs_arraylist) {
        this.sdjobs_arraylist=sdjobs_arraylist;
        this.context=context;
    }//end of constructor

    @Override
    public SdayViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View sdjobs_obj = LayoutInflater.from(parent.getContext()).inflate(R.layout.samedayjobscard, parent, false);
        return new SdayViewholder(sdjobs_obj);
    }//end of onCreateViewHolder method
    @Override
    public void onBindViewHolder(SdayViewholder holder, int position) {
        holder.title_txt.setText(sdjobs_arraylist.get(position));
    }//end of onBindViewHolder
    @Override
    public int getItemCount() {
        return sdjobs_arraylist.size();
    }//en dof getItemCount method

    public class SdayViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView_obj;
        TextView title_txt;
        public SdayViewholder(View itemView) {
            super(itemView);
            title_txt=itemView.findViewById(R.id.sdjjobtitleid);
            cardView_obj=itemView.findViewById(R.id.sdjcardviewid);
            cardView_obj.setOnClickListener(this);
        }//end of constructor

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.sdjcardviewid:
                    Intent job_intent=new Intent(itemView.getContext(),JobDescription.class);
                    basicComponentsReuse.intentmoveAnimateCode_method(itemView.getContext(),job_intent);
                    break;
            }//end of switch case
        }//end of onClick method
    }//end of viewholder class

}//end of main class
