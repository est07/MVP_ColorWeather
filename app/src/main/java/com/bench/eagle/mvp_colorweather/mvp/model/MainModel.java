package com.bench.eagle.mvp_colorweather.mvp.model;

import android.support.annotation.NonNull;

import com.bench.eagle.mvp_colorweather.models.CurrentWeather;
import com.bench.eagle.mvp_colorweather.models.Day;
import com.bench.eagle.mvp_colorweather.models.Hour;
import com.bench.eagle.mvp_colorweather.models.Minute;
import com.bench.eagle.mvp_colorweather.service.GetWeatherResponse;
import com.bench.eagle.mvp_colorweather.service.ListaWeatherService;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.observers.DisposableObserver;


public class MainModel {

    private ListaWeatherService listaWeatherService;

    public MainModel(ListaWeatherService listaWeatherService) {
        this.listaWeatherService = listaWeatherService;
    }

    public void getWeathers(@NonNull DisposableObserver<GetWeatherResponse> observer) {
          listaWeatherService.getListWeather(observer);
    }

}
