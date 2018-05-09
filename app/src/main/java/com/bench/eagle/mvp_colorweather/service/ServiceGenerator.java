package com.bench.eagle.mvp_colorweather.service;

import com.bench.eagle.mvp_colorweather.service.api.CostantsApi;
import com.bench.eagle.mvp_colorweather.service.api.WeatherClient;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceGenerator {

    /*private static WeatherClient weatherClient;

    public static WeatherClient getWeatherClient(){

        // Crear conexión al servicio REST
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(CostantsApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //...
        // Crear conexión a la API
        weatherClient = retrofit.create(WeatherClient.class);

        return weatherClient;
    }*/



    public static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().addInterceptor(new Interceptor() {

        @Override
        public Response intercept(Chain chain) throws IOException {

            Request defaultRequest = chain.request();

            HttpUrl defaulthttpUrl = defaultRequest.url();

            HttpUrl httpUrl = defaulthttpUrl.newBuilder()
                    .build();

            Request.Builder requestBuilder = defaultRequest.newBuilder().url(httpUrl);

            return chain.proceed(requestBuilder.build());
        }
    });


    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(CostantsApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.build();
        return retrofit.create(serviceClass);
    }
}
