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

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Button buttonSignup = findViewById(R.id.buttonLogin);

        buttonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView nameTv = findViewById(R.id.editTextTextPersonName);
                TextView phoneNumberTv = findViewById(R.id.editTextPhone);
                TextView ageTv = findViewById(R.id.editTextNumber);
                TextView emailTv = findViewById(R.id.editTextTextEmailAddress2);
                TextView passwordTv = findViewById(R.id.editTextTextPassword2);

                String name = nameTv.getText().toString();
                Integer phoneNumber = Integer.parseInt(phoneNumberTv.getText().toString());
                Integer age = Integer.parseInt(ageTv.getText().toString());
                String email = emailTv.getText().toString();
                String password = passwordTv.getText().toString();

                System.out.println(name);
                System.out.println(phoneNumber);
                System.out.println(age);
                System.out.println(email);
                System.out.println(password);

                if (name=="" || phoneNumberTv.getText().toString().length()!=9 || ageTv.getText().toString()=="" || email=="" || password==""){
                    Toast.makeText(SignupActivity.this, "Input fields are not correct", Toast.LENGTH_SHORT).show();
                } else {
                    AppService retrofitService = new AppService();
                    AppController connection = retrofitService.getConnection();
                    JSONObject jsonObject = new JSONObject();
                    try {
                        jsonObject.put("name",name);
                        jsonObject.put("age",age);
                        jsonObject.put("phone_number",phoneNumber);
                        jsonObject.put("email",email);
                        jsonObject.put("password",password);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    System.out.println("JSON:" + jsonObject.toString());
                    connection.riderSignup(jsonObject).enqueue(new Callback<Rider>() {
                        @Override
                        public void onResponse(Call<Rider> call, Response<Rider> response) {
                            Toast.makeText(SignupActivity.this, "Sign up successful", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Rider> call, Throwable t) {
                            Toast.makeText(SignupActivity.this, "Failed to connect with database", Toast.LENGTH_SHORT).show();
                        }
                    });
                    finish();
                }
            }
        });
    }
}