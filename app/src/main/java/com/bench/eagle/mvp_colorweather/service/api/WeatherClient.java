package com.bench.eagle.mvp_colorweather.service.api;


import com.bench.eagle.mvp_colorweather.models.CurrentWeather;
import com.bench.eagle.mvp_colorweather.models.Day;
import com.bench.eagle.mvp_colorweather.models.WeatherResponse;
import com.bench.eagle.mvp_colorweather.service.GetWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface WeatherClient {

    //https://api.darksky.net/forecast/d5ef0c0795745ad537d736156d3118e7/37.8267,-122.4233?units=si
    @GET("{dataLocation}")
    Call<GetWeatherResponse> getWeather( @Path("dataLocation") String datosUbicacion, @Query("units") String unist);

    @GET("{datosUbicacion}")
    Call<WeatherResponse<CurrentWeather>> getCurrentWeather(@Path("datosUbicacion") String datosUbicacion);

    @GET("{datosUbicacion}")
    Call<WeatherResponse> getWeatherResponce(@Path("datosUbicacion") String datosUbicacion);


}
