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


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Store> list;
    private Context context;

    RecyclerAdapter(List<Store> list, Context context){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Store items = list.get(i);
        viewHolder.global.setText(items.getItem());
        viewHolder.imageView.setImageResource(items.getImg());
        viewHolder.price.setText(items.getRate());

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
