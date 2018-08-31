package com.aski.routin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Number extends AppCompatActivity {

    EditText monum ;
    Button otp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number);

        monum = findViewById(R.id.monum);
        otp = findViewById(R.id.otp);

        otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mobile = monum.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    monum.setError("Enter a valid mobile");
                    monum.requestFocus();
                    return;
                }

                Intent intent = new Intent(getApplicationContext(), OTP.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);

            }
        });
    }
}
