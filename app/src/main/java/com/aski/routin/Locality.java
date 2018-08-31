package com.aski.routin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Locality extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String city[] = {"Bangalore","Chennai","Hyderabad"};
    String bangalore[] = {"Koramangala","Indira Nagar","Jayanagar","Whitefield"};
    String chennai[] = {"Egmore","Velachery","Guindy","Pallavaram"};
    String hyderabad[] = {"Tilak Nagar","Asif Nagar","GachiBowli","Braou"};
    String scity,sarea;
    private Spinner spinner,spin;
    private ImageView imageView;
    private Button button;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locality);

        button = findViewById(R.id.done);
        imageView = findViewById(R.id.cityimg);
        spinner = findViewById(R.id.city);
        spinner.setOnItemSelectedListener(this);

        spin = findViewById(R.id.area);
        spin.setOnItemSelectedListener(this);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();


        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,city);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(aa);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                databaseReference.child(mAuth.getCurrentUser().getUid()).child("details").child("city").child("city").setValue(scity);
                databaseReference.child(mAuth.getCurrentUser().getUid()).child("details").child("area").child("area").setValue(sarea);


                startActivity(new Intent(Locality.this,HomeScreen.class));

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(adapterView.getId() == R.id.city) {

            if(i==0){
                imageView.setImageResource(R.drawable.bangalore);

                ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,bangalore);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin.setAdapter(aa);

                scity = "Bangalore";
            }
            else if(i==1){
                imageView.setImageResource(R.drawable.chennai);

                ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,chennai);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin.setAdapter(aa);

                scity = "Chennai";
            }
            else {
                imageView.setImageResource(R.drawable.hyderabad);

                ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,hyderabad);
                aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spin.setAdapter(aa);

                scity = "Hyderabad";
            }
        }

        else{

            if(scity.equals("Bangalore")){

                if(bangalore[i].equals("Koramangala")){
                    sarea = "Koramangala";
                }
                else if(bangalore[i].equals("Indira Nagar")){
                    sarea = "Indira Nagar";
                }
                else if(bangalore[i].equals("Jayanagar")){
                    sarea = "Jayanagar";
                }
                else {
                    sarea = "Whitefield";
                }

            }
            else if(scity.equals("Chennai")){

                if(chennai[i].equals("Egmore")){
                    sarea = "Egmore";
                }
                else if(chennai[i].equals("Velachery")){
                    sarea = "Velachery";
                }
                else if(chennai[i].equals("Guindy")){
                    sarea = "Guindy";
                }
                else {
                    sarea = "Pallavaram";
                }

            }
            else {

                if(hyderabad[i].equals("Tilak Nagar")){
                    sarea = "Tilak Nagar";
                }
                else if(hyderabad[i].equals("Asif Nagar")){
                    sarea = "Asif Nagar";
                }
                else if(hyderabad[i].equals("GachiBowli")){
                    sarea = "GachiBowli";
                }
                else {
                    sarea = "Braou";
                }

            }

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
