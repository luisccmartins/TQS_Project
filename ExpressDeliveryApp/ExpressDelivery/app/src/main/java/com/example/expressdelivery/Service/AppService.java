package com.example.expressdelivery.Service;

import com.example.expressdelivery.Controller.AppController;
import com.google.gson.Gson;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class AppService {

    private Retrofit retrofit;

    private static AppController appController;

    public AppService() {
        initializeRetrofit();
    }

    public void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://localhost:9010")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public static AppController getConnection(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        appController = new Retrofit.Builder().baseUrl("http://10.0.2.2:9010")
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(client).build().create(AppController.class);
        return appController;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }


}