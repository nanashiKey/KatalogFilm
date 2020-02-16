package com.ngopidev.project.katalogfilm.activites;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.ngopidev.project.katalogfilm.R;


/**
 * created by Irfan Assidiq on 2020-02-16
 * email : assidiq.irfan@gmail.com
 **/
public class SplashActivity extends AppCompatActivity {

    private final int lamaMuncul = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                finish();
            }
        }, lamaMuncul);
    }
}
