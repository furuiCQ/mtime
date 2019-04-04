package com.markfrain.mtime;

import android.app.Application;

import com.markfrain.mtime.http.HttpContact;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApplication extends Application {
    public static HttpContact httpContact;
    public static HttpContact httpSubContact;

    public static final int DEFAULT_TIME = 10;

    @Override
    public void onCreate() {
        super.onCreate();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .readTimeout(DEFAULT_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .connectTimeout(DEFAULT_TIME, TimeUnit.SECONDS)//设置请求超时时间
                .writeTimeout(DEFAULT_TIME, TimeUnit.SECONDS)//设置写入超时时间
                .addNetworkInterceptor(new HttpLoggingInterceptor(new HttpLogger()))
                .retryOnConnectionFailure(true)//设置出现错误进行重新连接。
                .build();

        Retrofit retrofit = new Retrofit
                .Builder()
                .client(client)
                .baseUrl("http://m.mtime.cn/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        httpContact = retrofit.create(HttpContact.class);

        Retrofit retrofit2 = new Retrofit
                .Builder()
                .client(client)
                .baseUrl("http://ticket-m.mtime.cn/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        httpSubContact = retrofit2.create(HttpContact.class);

        Logger.addLogAdapter(new AndroidLogAdapter());

    }
    class HttpLogger implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            Logger.d(message);
        }
    }
}

