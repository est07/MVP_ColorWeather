package com.bench.eagle.mvp_colorweather.mvp.model;

import android.support.annotation.NonNull;

import com.bench.eagle.mvp_colorweather.service.GetWeatherResponse;
import com.bench.eagle.mvp_colorweather.service.ListWeatherService;

import io.reactivex.observers.DisposableObserver;


public class MainModel {

    private ListWeatherService listWeatherService;
    private String dataLoction;

    public MainModel(ListWeatherService listWeatherService, String dataLoction) {
        this.listWeatherService = listWeatherService;
        this.dataLoction = dataLoction;
    }

    public void getWeathers(@NonNull DisposableObserver<GetWeatherResponse> observer) {
          listWeatherService.getListWeather(observer, dataLoction);
    }

}
