package com.aski.routin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AccountFragment extends Fragment {

    FirebaseAuth mAuth;
    TextView myname,myemail,mynum;
    ImageView imgs;
    Button bu1,bu2;
    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_account, null);

        myemail = view.findViewById(R.id.email);
        myname = view.findViewById(R.id.name);
        mynum = view.findViewById(R.id.number);
        imgs = view.findViewById(R.id.gender);
        bu1 = view.findViewById(R.id.orders);
        bu2 = view.findViewById(R.id.subscription);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        mynum.setText(mAuth.getCurrentUser().getPhoneNumber());

        databaseReference.child(mAuth.getCurrentUser().getUid()).child("details").child("name").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String message = dataSnapshot.getValue().toString();

                myname.setText(message);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                String message = dataSnapshot.getValue().toString();

                myname.setText(message);
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

        databaseReference.child(mAuth.getCurrentUser().getUid()).child("details").child("email").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String message = dataSnapshot.getValue().toString();

                myemail.setText(message);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                String message = dataSnapshot.getValue().toString();

                myemail.setText(message);
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

        databaseReference.child(mAuth.getCurrentUser().getUid()).child("details").child("gender").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                String message = dataSnapshot.getValue().toString();

                if(message.equals("Male")){
                    imgs.setImageResource(R.drawable.male);
                }
                else {
                    imgs.setImageResource(R.drawable.female);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                String message = dataSnapshot.getValue().toString();

                if(message.equals("Male")){
                    imgs.setImageResource(R.drawable.male);
                }
                else {
                    imgs.setImageResource(R.drawable.female);
                }
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

        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),MyOrders.class));
            }
        });

        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(),Subscription.class));
            }
        });

        return view;
    }
}
