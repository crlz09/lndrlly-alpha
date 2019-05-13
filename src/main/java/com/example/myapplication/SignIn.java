package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SignIn extends AppCompatActivity {
    TextInputEditText user, pass;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
      //  Button signUp = findViewById(R.id.btnSignUp);
        Button login = findViewById(R.id.btnSignIn);

        user = findViewById(R.id.EtPhone);
        pass = findViewById(R.id.EtPassword);
        user.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

//        signUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent go = new Intent(getApplicationContext(), SignUp.class);
//                startActivity(go);
//                finish();
//            }
//        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go = new Intent(getApplicationContext(), Verification.class);
                startActivity(go);
                finish();
            }
        });
    }
}
