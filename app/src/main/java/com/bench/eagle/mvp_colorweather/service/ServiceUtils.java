package com.bench.eagle.mvp_colorweather.service;



public class ServiceUtils {

    private static ListWeatherService listWeatherService;

    private ServiceUtils(){}

    public static final ListWeatherService getItemService() {
        if (listWeatherService == null) {
            listWeatherService = new ListWeatherService();
        }
        return listWeatherService;
    }
}
