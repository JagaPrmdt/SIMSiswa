package com.example.siswa.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    private static final String BASE_URL ="https://script.google.com/macros/s/AKfycbwR2AHVOeg7uCZAafy4WhYoVhRcggOWXihwbgm08e4EzxNiKC7F/";

    private static OkHttpClient okHttpClient = new OkHttpClient()
            .newBuilder()
            .connectTimeout(60,TimeUnit.SECONDS)
            .readTimeout(60,TimeUnit.SECONDS)
            .writeTimeout(60,TimeUnit.SECONDS)
            .build();

    private static Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();
    public static <S> S createService(Class<S> serviceClass){
        return retrofit.create(serviceClass);
    }
}
