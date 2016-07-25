package com.rxjavademo.admin.retrofitandrxjavademo.https.inithttp;

import com.rxjavademo.admin.retrofitandrxjavademo.https.urls.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/4/11.
 */
public class ServiceClient {

    private static Service instance;

    public static Service getService(){
        if(instance == null){
            instance = createService();
        }
        return instance;
    }


    private static Service createService(){
        return instance = createRetrofit(createOkHttpClient()).create(Service.class);
    }


    private static Retrofit createRetrofit(OkHttpClient client){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Service.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }

    private static OkHttpClient createOkHttpClient(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .addNetworkInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request.Builder builder = chain.request().newBuilder();
                        Request request = builder.build();
                        return chain.proceed(request);
                    }
                })
                .build();
        return client;
    }

}
