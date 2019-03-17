package com.example.myapplication;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Laundry extends AppCompatActivity {
    Typeface custom_font;
    Typeface font_title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laundry);
         custom_font = Typeface.createFromAsset(getAssets(), "fonts/nunito.ttf");
         font_title = Typeface.DEFAULT;


        final TextView tv = (TextView) findViewById(R.id.textView);
        Button normal = (Button) findViewById(R.id.button);
        Button nunito = (Button) findViewById(R.id.button2);

        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setTypeface(font_title);
                tv.setText("Bienvenido");
            }
        });

        nunito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setTypeface(custom_font);
                tv.setText("Bienvenido");
            }
        });
    }
}
