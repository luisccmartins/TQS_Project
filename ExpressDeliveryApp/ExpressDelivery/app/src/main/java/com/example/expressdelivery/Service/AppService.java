package com.example.expressdelivery.Service;

import com.google.gson.Gson;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class AppService {

    private Retrofit retrofit;

    public AppService() {
        initializeRetrofit();
    }

    private void initializeRetrofit() {
        retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:9010")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
}