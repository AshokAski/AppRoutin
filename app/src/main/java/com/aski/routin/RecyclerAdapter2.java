package com.aski.routin;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerAdapter2 extends RecyclerView.Adapter<RecyclerAdapter2.ViewHolder> {

    private List<Store> list;
    private Context context;

    RecyclerAdapter2(List<Store> list, Context context){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerAdapter2.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter2.ViewHolder viewHolder, int i) {

        Store items = list.get(i);
        viewHolder.global.setText(items.getItem2());
        viewHolder.imageView.setImageResource(items.getImg2());
        viewHolder.rate.setText(items.getRate2());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView global,rate;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            global = itemView.findViewById(R.id.global);
            imageView = itemView.findViewById(R.id.img);
            rate = itemView.findViewById(R.id.price);
        }
    }

}
