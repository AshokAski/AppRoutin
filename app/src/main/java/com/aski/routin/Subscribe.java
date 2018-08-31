package com.aski.routin;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Subscribe extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    Button starti,endi,orderi;
    DatabaseReference databaseReference ;
    FirebaseAuth mAuth;
    String start1,end1;
    int x=0,y=0,flag=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        starti = findViewById(R.id.start);
        endi = findViewById(R.id.end);
        orderi = findViewById(R.id.porder);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        Intent intent = getIntent();

        final int image = intent.getExtras().getInt("image");

        orderi.setVisibility(View.INVISIBLE);

        starti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag = 1;
                DialogFragment datepicker = new com.aski.routin.DatePicker();
                datepicker.show(getSupportFragmentManager(),"date picker");

            }
        });

        endi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                flag =2;
                DialogFragment datepicker = new com.aski.routin.DatePicker();
                datepicker.show(getSupportFragmentManager(),"date picker");

            }
        });

        orderi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference.child(mAuth.getCurrentUser().getUid()).child("subs").push().setValue(start1+"&"+image+"&"+end1);

                Toast.makeText(getApplicationContext(),"Order Placed, Continue Shopping.",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),HomeScreen.class));
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
        String text = i2+"."+i1+"."+i;

        if(flag==1){

            start1 = text;
            starti.setText(text);

            x=1;

            if(y==1){
                orderi.setVisibility(View.VISIBLE);
            }
        }
        else {

            end1 = text;
            endi.setText(text);

            y=1;

            if(x==1){
                orderi.setVisibility(View.VISIBLE);
            }
        }
    }
}
