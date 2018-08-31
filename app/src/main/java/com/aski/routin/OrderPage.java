package com.aski.routin;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class OrderPage extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener, DatePickerDialog.OnDateSetListener{

    TextView item,rate;
    ImageView imageView;
    Button buynow,subs,dates,times,orders;
    DatabaseReference databaseReference ;
    FirebaseAuth mAuth;
    String texts;
    int a=0,b=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);

        imageView = findViewById(R.id.image);
        item = findViewById(R.id.name);
        rate = findViewById(R.id.price);
        buynow = findViewById(R.id.buy);
        subs = findViewById(R.id.sub);
        dates = findViewById(R.id.date);
        times = findViewById(R.id.time);
        orders = findViewById(R.id.order);

        dates.setVisibility(View.INVISIBLE);
        times.setVisibility(View.INVISIBLE);
        orders.setVisibility(View.INVISIBLE);

        databaseReference = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        Intent intent = getIntent();

        String string = intent.getExtras().getString("string");
        final String rates = intent.getExtras().getString("rate");
        final int image = intent.getExtras().getInt("img");

        item.setText("  "+string);
        rate.setText("  "+rates);
        imageView.setImageResource(image);

        buynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                subs.setVisibility(View.INVISIBLE);
                dates.setVisibility(View.VISIBLE);
                times.setVisibility(View.VISIBLE);

            }
        });

        subs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),Subscribe.class);
                intent.putExtra("image",image);
                startActivity(intent);
            }
        });

        dates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment datepicker = new com.aski.routin.DatePicker();
                datepicker.show(getSupportFragmentManager(),"date picker");

            }
        });

        times.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogFragment timepicker = new TimePicker();
                timepicker.show(getSupportFragmentManager(), "time picker");

            }
        });

        orders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                databaseReference.child(mAuth.getCurrentUser().getUid()).child("orders").push().setValue(texts+"&"+image+"&"+rates);

                Toast.makeText(getApplicationContext(),"Order Placed, Continue Shopping.",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),HomeScreen.class));
            }
        });

    }

    @Override
    public void onTimeSet(android.widget.TimePicker timePicker, int i, int i1) {

        String text = i+":"+i1;
        times.setText(text);

        b=1;

        if(a==1){
            orders.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

        texts = i2+"."+i1+"."+i;
        dates.setText(texts);

        a=1;

        if(b==1){
            orders.setVisibility(View.VISIBLE);
        }

    }
}
