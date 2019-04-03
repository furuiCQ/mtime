package com.markfrain.mtime;

import android.app.Application;

import com.markfrain.mtime.http.HttpContact;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {
    public static HttpContact httpContact;

    @Override
    public void onCreate() {
        super.onCreate();
        Retrofit retrofit = new Retrofit
                .Builder().baseUrl("http://m.mtime.cn/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        httpContact = retrofit.create(HttpContact.class);
    }
}
