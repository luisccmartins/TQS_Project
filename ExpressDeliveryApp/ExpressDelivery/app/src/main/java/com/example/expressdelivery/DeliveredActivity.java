package com.example.expressdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DeliveredActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivered);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent previousIntent = getIntent();
        String orderId = previousIntent.getStringExtra("orderId");
        String orderDescription= previousIntent.getStringExtra("orderDescription");
        String orderDestination= previousIntent.getStringExtra("orderDestination");
        String orderPhoneNumber= previousIntent.getStringExtra("orderPhoneNumber");

        TextView orderIdTV = findViewById(R.id.textView32);
        TextView orderDescriptionTV = findViewById(R.id.textView34);
        TextView orderDestinationTV = findViewById(R.id.textView36);
        TextView orderPhoneNumberTV = findViewById(R.id.textView38);

        orderIdTV.setText(orderId);
        orderDescriptionTV.setText(orderDescription);
        orderDestinationTV.setText(orderDestination);
        orderPhoneNumberTV.setText(orderPhoneNumber);
    }
}