package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SignUp extends AppCompatActivity {

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
         Button signUp = findViewById(R.id.btnSignUp);
         LinearLayout login = findViewById(R.id.btnLogin);

         signUp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent go = new Intent(getApplicationContext(), Verification.class);
                 startActivity(go);
                 finish();
             }
         });

         login.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent go = new Intent(getApplicationContext(), SignIn.class);
                 startActivity(go);
                 finish();
             }
         });


    }
}
