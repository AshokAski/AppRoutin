package com.aski.routin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends AppCompatActivity {

    private RecyclerView item;
    private RecyclerView.Adapter adapter2;
    private Store store;
    private List<Store> list2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adapter);

        Intent intent = getIntent();

        String string = intent.getExtras().getString("string");

        item = findViewById(R.id.item2);
        item.setHasFixedSize(true);
        item.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        list2 = new ArrayList<>();

        adapter2 = new RecyclerAdapter2(list2,getApplicationContext());

        if(string.equals("Fruits & Vegetables")){
            String[] fruits = {"Apple","Orange","Banana","Carrot","Potato","Tomato"};
            String[] price = {"Rs.120","Rs.70","Rs.30","Rs.40","Rs.35","Rs.15"};
            int[] img = {R.drawable.apple,R.drawable.orange,R.drawable.banana,R.drawable.carrot,R.drawable.potato,R.drawable.tomato};
            for(int i=0;i<6;i++){
                store = new Store(fruits[i],price[i],img[i]);
                list2.add(store);
                item.setAdapter(adapter2);
            }
        }
        else if(string.equals("Meats")){
            String[] meats = {"Chicken","Mutton","Crab","Prawn","Fish"};
            String[] price = {"Rs.120","Rs.500","Rs.400","Rs.100","Rs.150"};
            int[] img = {R.drawable.chicken,R.drawable.mutton,R.drawable.crab,R.drawable.prawn,R.drawable.fish};
            for(int i=0;i<5;i++){
                store = new Store(meats[i],price[i],img[i]);
                list2.add(store);
                item.setAdapter(adapter2);
            }
        }
        else if(string.equals("Dairy")){
            String[] dairy = {"Butter","Curd","Milk","Ghee","Cheese","Paneer"};
            String[] price = {"Rs.100","Rs.30","Rs.25","Rs.120","Rs.80","Rs.50"};
            int[] img = {R.drawable.butter,R.drawable.curd,R.drawable.milk,R.drawable.ghee,R.drawable.cheese,R.drawable.paneer};
            for(int i=0;i<6;i++){
                store = new Store(dairy[i],price[i],img[i]);
                list2.add(store);
                item.setAdapter(adapter2);
            }
        }
        else if(string.equals("Groceries & Staples")){
            String[] grocery = {"Salt","Sugar","Rice","Wheat","Pickle","Olive oil"};
            String[] price = {"Rs.50","Rs.100","Rs.500","Rs.200","Rs.50","Rs.300"};
            int[] img = {R.drawable.salt,R.drawable.sugar,R.drawable.rice,R.drawable.wheat,R.drawable.pickle,R.drawable.oliveoil};
            for(int i=0;i<6;i++){
                store = new Store(grocery[i],price[i],img[i]);
                list2.add(store);
                item.setAdapter(adapter2);
            }
        }
        else if(string.equals("Bakery")){
            String[] bakery = {"Breads","Chocolates","Cakes","Biscuits","Pizza","Roll","Puffs"};
            String[] price = {"Rs.35","Rs.100","Rs.250","Rs.150","Rs.200","Rs.45","Rs.40"};
            int[] img = {R.drawable.bread,R.drawable.chocolate,R.drawable.cake,R.drawable.biscuits,R.drawable.pizza,R.drawable.roll,R.drawable.puffs};
            for(int i=0;i<7;i++){
                store = new Store(bakery[i],price[i],img[i]);
                list2.add(store);
                item.setAdapter(adapter2);
            }
        }
        else if(string.equals("Household")){
            String[] house = {"Brush","Paste","Mouth wash","Soap","Dish wash","Shampoo"};
            String[] price = {"Rs.40","Rs.50","Rs.99","Rs.170","Rs.70","Rs.250"};
            int[] img = {R.drawable.brush,R.drawable.paste,R.drawable.mouthwash,R.drawable.soap,R.drawable.dishwash,R.drawable.shampoo};
            for(int i=0;i<6;i++){
                store = new Store(house[i],price[i],img[i]);
                list2.add(store);
                item.setAdapter(adapter2);
            }
        }

        item.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),item, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Store store = list2.get(position);
                String string = store.getItem2();
                int img = store.getImg2();
                String rate = store.getRate2();

                Intent intent = new Intent(getApplicationContext(),OrderPage.class);
                intent.putExtra("string",string);
                intent.putExtra("img",img);
                intent.putExtra("rate",rate);

                startActivity(intent);

            }
        }));

    }
}
