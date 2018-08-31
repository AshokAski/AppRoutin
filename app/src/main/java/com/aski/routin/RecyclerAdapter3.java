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

public class RecyclerAdapter3 extends RecyclerView.Adapter<RecyclerAdapter3.ViewHolder> {

    private List<Store> list;
    private Context context;

    RecyclerAdapter3(List<Store> list, Context context){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerAdapter3.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RecyclerAdapter3.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter3.ViewHolder viewHolder, int i) {

        Store items = list.get(i);
        viewHolder.global.setText(items.getDate3());
        viewHolder.imageView.setImageResource(items.getImg3());
        viewHolder.price.setText(items.getRate3());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView global,price;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            global = itemView.findViewById(R.id.global);
            imageView = itemView.findViewById(R.id.img);
            price = itemView.findViewById(R.id.price);
        }
    }

}
