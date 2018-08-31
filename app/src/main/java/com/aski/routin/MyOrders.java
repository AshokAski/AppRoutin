package com.aski.routin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyOrders extends AppCompatActivity {

    FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    private RecyclerView item;
    private RecyclerView.Adapter adapter;
    private Store store;
    private List<Store> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        item = findViewById(R.id.orderview);
        item.setHasFixedSize(true);
        item.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        list = new ArrayList<>();

        adapter = new RecyclerAdapter3(list,getApplicationContext());

        databaseReference.child(mAuth.getCurrentUser().getUid()).child("orders").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String message = dataSnapshot.getValue().toString();

                String sent[] = message.split("&");

                String date = sent[0];
                String rate = sent[2];
                int img = Integer.parseInt(sent[1]);

                store = new Store(img,date,rate,img);
                list.add(store);
                item.setAdapter(adapter);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
