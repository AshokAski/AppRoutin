package com.aski.routin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserInfo extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private ImageView imageView;
    private EditText name,email;
    private Button signup;
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;

    String usid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        radioGroup = findViewById(R.id.radio);
        imageView = findViewById(R.id.user);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        signup = findViewById(R.id.Signup);

        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        usid = "Male";

        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(selectedId);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(selectedId);

                usid = (String) radioButton.getText();

                if(usid.equals("Male")){
                    imageView.setImageResource(R.drawable.male);
                }
                else {
                    imageView.setImageResource(R.drawable.female);
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = String.valueOf(email.getText());
                String nam = String.valueOf(name.getText());

                if(nam.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Enter your Name",Toast.LENGTH_LONG).show();

                }
                else {
                    if(mail.contains("@")){

                        databaseReference.child(mAuth.getCurrentUser().getUid()).child("details").child("name").child("name").setValue(nam);
                        databaseReference.child(mAuth.getCurrentUser().getUid()).child("details").child("email").child("email").setValue(mail);
                        databaseReference.child(mAuth.getCurrentUser().getUid()).child("details").child("gender").child("gender").setValue(usid);

                        startActivity(new Intent(UserInfo.this,Locality.class));

                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Enter Valid mail address",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
