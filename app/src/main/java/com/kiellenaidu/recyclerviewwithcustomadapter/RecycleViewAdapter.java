package com.kiellenaidu.recyclerviewwithcustomadapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<President> presidentList;
    Context context;

    public RecycleViewAdapter(List<President> presidentList, Context context) {
        this.presidentList = presidentList;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_president, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt_PresidentName.setText(presidentList.get(position).getName());
        holder.txt_DateElection.setText(String.valueOf(presidentList.get(position).getDateOfElection()));
        Glide.with(this.context).load(presidentList.get(position).getImageURL()).into(holder.iv_PresidentsPicture);
        holder.oneLinePresidentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //send the control to the EditOneItem activity
                Intent intent = new Intent(context,AddEditOne.class);
                intent.putExtra("id",presidentList.get(holder.getAdapterPosition()).getId()); //get(position)
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return presidentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView iv_PresidentsPicture;
        TextView txt_PresidentName;
        TextView txt_DateElection;
        ConstraintLayout oneLinePresidentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_PresidentsPicture = itemView.findViewById(R.id.iv_PresidentsPicture);
            txt_PresidentName = itemView.findViewById(R.id.txt_PresidentName);
            txt_DateElection = itemView.findViewById(R.id.txt_DateElection);
            oneLinePresidentLayout =itemView.findViewById(R.id.oneLinePresidentLayout);
        }
    }
}
