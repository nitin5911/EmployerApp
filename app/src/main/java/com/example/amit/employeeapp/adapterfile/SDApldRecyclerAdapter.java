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

public class SDApldRecyclerAdapter extends RecyclerView.Adapter<SDApldRecyclerAdapter.SdaViewholder> {

    ArrayList<String> sdajobs_arraylist=new ArrayList<>();
    Context context;
    BasicComponentsReuse basicComponentsReuse=new BasicComponentsReuse();

    public SDApldRecyclerAdapter(Context context, ArrayList<String> sdajobs_arraylist) {
        this.sdajobs_arraylist=sdajobs_arraylist;
        this.context=context;
    }//end of constructor

    @Override
    public SdaViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View sdajobs_obj = LayoutInflater.from(parent.getContext()).inflate(R.layout.samedayjobscard, parent, false);
        return new SdaViewholder(sdajobs_obj);
    }//end of onCreateViewHolder method
    @Override
    public void onBindViewHolder(SdaViewholder holder, int position) {
        holder.title_txt.setText(sdajobs_arraylist.get(position));
    }//end of onBindViewHolder
    @Override
    public int getItemCount() {
        return sdajobs_arraylist.size();
    }//en dof getItemCount method

    public class SdaViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView_obj;
        TextView title_txt;
        public SdaViewholder(View itemView) {
            super(itemView);
            title_txt=itemView.findViewById(R.id.sdjjobtitleid);
            cardView_obj=itemView.findViewById(R.id.sdjcardviewid);
            cardView_obj.setOnClickListener(this);
        }//end of constructor

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.sdjcardviewid:
                    Intent ajob_intent=new Intent(itemView.getContext(),AppliedJobDescription.class);
                    basicComponentsReuse.intentmoveAnimateCode_method(itemView.getContext(),ajob_intent);
                    break;
            }//end of switch case
        }//end of onClick method
    }//end of viewholder class

}//end of main class