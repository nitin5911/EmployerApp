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
import com.example.amit.employeeapp.activities.JobDescription;

import java.util.ArrayList;

public class BkdayRecyclerAdapter  extends RecyclerView.Adapter<BkdayRecyclerAdapter.BKdayViewholder> {

    ArrayList<String> bkjobs_arraylist=new ArrayList<>();
    Context context;
    BasicComponentsReuse basicComponentsReuse=new BasicComponentsReuse();

    public BkdayRecyclerAdapter(Context context, ArrayList<String> bkjobs_arraylist) {
        this.bkjobs_arraylist=bkjobs_arraylist;
        this.context=context;
    }//end of constructor

    @Override
    public BKdayViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View bkjobs_obj = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookedjobscard, parent, false);
        return new BKdayViewholder(bkjobs_obj);
    }//end of onCreateViewHolder method

    @Override
    public void onBindViewHolder(BKdayViewholder holder, int position) {
        holder.title_txt.setText(bkjobs_arraylist.get(position));
    }//end of onBindViewHolder method

    @Override
    public int getItemCount() {
        return bkjobs_arraylist.size();
    }//end of getItemCount method

    public class BKdayViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView_obj;
        TextView title_txt;
        public BKdayViewholder(View itemView) {
            super(itemView);
            title_txt=itemView.findViewById(R.id.bkdjjobtitleid);
            cardView_obj=itemView.findViewById(R.id.bkdjcardviewid);
            cardView_obj.setOnClickListener(this);
        }//end of constructor

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.bkdjcardviewid:
                    Intent job_intent=new Intent(itemView.getContext(),JobDescription.class);
                    basicComponentsReuse.intentmoveAnimateCode_method(itemView.getContext(),job_intent);
                    break;
            }//end of switch case
        }//end of onClick method
    }//end of viewholder class
}//end of main class