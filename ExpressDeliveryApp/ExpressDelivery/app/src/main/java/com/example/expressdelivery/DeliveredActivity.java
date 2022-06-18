package com.example.expressdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DeliveredActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivered);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}