package com.aski.routin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class StoreFragment extends Fragment {

    private RecyclerView item;
    private RecyclerView.Adapter adapter;
    private Store store;
    private List<Store> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_store, null);

        item = view.findViewById(R.id.rview);
        item.setHasFixedSize(true);
        item.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        adapter = new RecyclerAdapter(list,getContext());

        String[] categ = {"Fruits & Vegetables","Meats","Dairy","Groceries & Staples","Bakery","Household"};
        int[] vimg = {R.drawable.fruits,R.drawable.meat,R.drawable.dairy,R.drawable.grocery,R.drawable.bakery,R.drawable.household};
        String[] rate = {"Min. Rs.15","Min. Rs.100","Min. Rs.25","Min. Rs.50","Min. Rs.35","Min. Rs.40"};

        for(int i=0;i<6;i++){
            store = new Store(vimg[i],categ[i],rate[i]);
            list.add(store);
            item.setAdapter(adapter);
        }

        item.addOnItemTouchListener(new RecyclerTouchListener(getContext(),item, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Store store = list.get(position);
                String string = store.getItem();

                Intent intent = new Intent(getContext(),ListAdapter.class);
                intent.putExtra("string",string);

                startActivity(intent);

            }
        }));

        return view;
    }



}
