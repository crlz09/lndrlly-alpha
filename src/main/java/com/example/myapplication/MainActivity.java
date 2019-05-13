package com.example.myapplication;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.myapplication.Fragments.Laundry;
import com.example.myapplication.Fragments.Orders;
import com.example.myapplication.Fragments.Profile;
import com.example.myapplication.Fragments.Promotions;
import com.example.myapplication.Fragments.Settings;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction ft;
    Laundry laundry = new Laundry();
    Orders orders = new Orders();
    Profile profile = new Profile();
    Promotions promotions = new Promotions();
    Settings settings = new Settings();



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            ft = fragmentManager.beginTransaction();

            switch (item.getItemId()) {
                case R.id.navigation_home:

                    ft.replace(R.id.LLmain,laundry).
                            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();



                    return true;
                case R.id.navigation_dashboard:
                    ft.replace(R.id.LLmain,orders).
                            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

                    return true;


                case R.id.navigation_promotions:
                    ft.replace(R.id.LLmain,promotions).
                            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

                    return true;

                case R.id.navigation_profile:

                    ft.replace(R.id.LLmain,profile).
                            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

                    return true;

                case R.id.navigation_settings:
                    ft.replace(R.id.LLmain,settings).
                            setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Laundrelly");
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        ft=fragmentManager.beginTransaction();
        ft.add(R.id.LLmain, laundry).
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

    }

}
