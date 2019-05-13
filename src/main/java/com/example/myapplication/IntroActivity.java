package com.example.myapplication;

import android.content.Intent;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Fragments.LastSlide;
import com.example.myapplication.Fragments.SecondSlide;
import com.example.myapplication.Fragments.ThirdSlide;
import com.example.myapplication.Fragments.firstSlide;
import com.example.myapplication.Methods.PrefManager;

import agency.tango.materialintroscreen.MaterialIntroActivity;
import agency.tango.materialintroscreen.animations.IViewTranslation;

public class IntroActivity extends MaterialIntroActivity {
    private PrefManager prefManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        prefManager = new PrefManager(this);
        if (!prefManager.isFirstTimeLaunch()) {
            onFinish();
        }

        enableLastSlideAlphaExitTransition(true);

        getBackButtonTranslationWrapper()
                .setEnterTranslation(new IViewTranslation() {
                    @Override
                    public void translate(View view, @FloatRange(from = 0, to = 1.0) float percentage) {
                        view.setAlpha(percentage);
                    }
                });

        addSlide(new firstSlide());
        addSlide(new SecondSlide());
        addSlide(new ThirdSlide());
        addSlide(new LastSlide());
        prefManager.setFirstTimeLaunch(false);

    }
    @Override
    public void onFinish() {
        super.onFinish();
        Intent go = new Intent(getApplicationContext(), SignIn.class);
        startActivity(go);
        finish();
    }
}
