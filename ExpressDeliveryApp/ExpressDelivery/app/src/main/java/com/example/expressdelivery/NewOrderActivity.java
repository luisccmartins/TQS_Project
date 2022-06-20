package com.example.expressdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expressdelivery.Controller.AppController;
import com.example.expressdelivery.Service.AppService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent previousIntent = getIntent();
        String orderId = previousIntent.getStringExtra("orderId");
        String orderDescription= previousIntent.getStringExtra("orderDescription");
        String orderDestination= previousIntent.getStringExtra("orderDestination");
        String orderPhoneNumber= previousIntent.getStringExtra("orderPhoneNumber");
        String riderEmail= previousIntent.getStringExtra("riderEmail");

        TextView orderIdTV = findViewById(R.id.textView3);
        TextView orderDescriptionTV = findViewById(R.id.textView5);
        TextView orderDestinationTV = findViewById(R.id.textView7);
        TextView orderPhoneNumberTV = findViewById(R.id.textView9);

        orderIdTV.setText(orderId);
        orderDescriptionTV.setText(orderDescription);
        orderDestinationTV.setText(orderDestination);
        orderPhoneNumberTV.setText(orderPhoneNumber);

        Button buttonAccept = findViewById(R.id.buttonAccept);
        String state = "PICKED UP";

        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppService retrofitService = new AppService();
                AppController connection = retrofitService.getConnection();

                connection.updateOrderStatus(orderId,riderEmail,state).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Toast.makeText(getApplicationContext(), "Successful!", Toast.LENGTH_SHORT).show();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Failed to connect with database!!!", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                });
            }
        });
    }
}