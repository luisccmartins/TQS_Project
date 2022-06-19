package com.example.expressdelivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.expressdelivery.Controller.AppController;
import com.example.expressdelivery.Model.Rider;
import com.example.expressdelivery.Service.AppService;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button buttonRegister = findViewById(R.id.buttonRegister);
        Button buttonLogin = findViewById(R.id.buttonLogin);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView emailTv = findViewById(R.id.editTextTextEmailAddress3);
                TextView passwordTv = findViewById(R.id.editTextTextPassword3);

                String email = emailTv.getText().toString();
                String password = passwordTv.getText().toString();

                if (email=="" || password==""){
                    Toast.makeText(LoginActivity.this, "Input fields are not correct", Toast.LENGTH_SHORT).show();
                } else {
                    AppService retrofitService = new AppService();
                    AppController connection = retrofitService.getConnection();
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("email", email);
                        jsonObject.put("password", password);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    connection.riderLogin(jsonObject).enqueue(new Callback<Rider>() {
                        @Override
                        public void onResponse(Call<Rider> call, Response<Rider> response) {
                            Toast.makeText(LoginActivity.this, "Login up successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
                            intent.putExtra("email", response.body().getEmail().toString());
                            setResult(123, intent);
                            finish();
                        }

                        @Override
                        public void onFailure(Call<Rider> call, Throwable t) {
                            Toast.makeText(LoginActivity.this, "Failed to connect with database", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent();
                            intent.putExtra("email", "");
                            setResult(123, intent);
                            finish();
                        }
                    });
                }

            }
        });
    }
}