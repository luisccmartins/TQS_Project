package com.example.expressdelivery;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;

public class MyAdapterNew extends RecyclerView.Adapter<MyAdapterNew.MyViewHolder> {

    private RecyclerViewClickListener listener;
    Context context;
    List<Integer> arrayId;
    List<String> arrayDescription;

    public  MyAdapterNew(Context ct, List<Integer> arrayId, List<String> arrayDescription, RecyclerViewClickListener listener){
        this.context = ct;
        this.arrayId = arrayId;
        this.arrayDescription = arrayDescription;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view   = inflater.inflate(R.layout.row_recyclerview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewId.setText(arrayId.get(position).toString());
        holder.textViewDescription.setText(arrayDescription.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return arrayId.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView textViewId;
        TextView textViewDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewId = itemView.findViewById(R.id.textViewId);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());
        }
    }

    public interface RecyclerViewClickListener{
        void onClick(View view, int position);
    }

}