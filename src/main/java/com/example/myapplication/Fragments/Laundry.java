package com.example.myapplication.Fragments;

import android.animation.ArgbEvaluator;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.Methods.CardViewModel;
import com.example.myapplication.Methods.CardViewPageAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public  class Laundry extends Fragment {
    ViewPager viewPager;
    CardViewPageAdapter cardViewPageAdapter;
    List<CardViewModel> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    public Laundry(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.f_laundry, container, false);
         models = new ArrayList<>();models.add(new CardViewModel(
                 R.drawable.wf,
                getResources().getString(R.string.washfold_title),
                getResources().getString(R.string.washfold_desc)));

        models.add(new CardViewModel(R.drawable.drycleaning,
                getResources().getString(R.string.drycleaning_title),
                getResources().getString(R.string.drycleaning_desc)));

        models.add(new CardViewModel(R.drawable.specialg,
                getResources().getString(R.string.specialgarments_title),
                getResources().getString(R.string.specialgarmets_desc)));

        cardViewPageAdapter = new CardViewPageAdapter(models,getActivity().getApplicationContext());
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(cardViewPageAdapter);
        viewPager.setPadding(130,0,130,0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3)
                        };
        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int postionOffsetPixels) {
                if (position < (cardViewPageAdapter.getCount() -1) && position < (colors.length -1)){
                    viewPager.setBackgroundColor(
                            (Integer)argbEvaluator.evaluate(
                                    positionOffset, colors[position],colors[position +1])
                    );

                } else {
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });





        return view;


    }

}