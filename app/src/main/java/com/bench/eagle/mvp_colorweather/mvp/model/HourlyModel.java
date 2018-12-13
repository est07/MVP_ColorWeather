package com.bench.eagle.mvp_colorweather.mvp.model;

import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;

import java.util.ArrayList;

public class HourlyModel {

    private String timeZone;

    private ArrayList<DataWeatherResponse> hourlyWeatherResonse;

    public HourlyModel(ArrayList<DataWeatherResponse> hourlyWeatherResonse, String timeZone) {
        this.hourlyWeatherResonse = hourlyWeatherResonse;
        this.timeZone = timeZone;
    }


    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public ArrayList<DataWeatherResponse> getHourlyWeatherResonse() {
        return hourlyWeatherResonse;
    }

    public void setHourlyWeatherResonse(ArrayList<DataWeatherResponse> hourlyWeatherResonse) {
        this.hourlyWeatherResonse = hourlyWeatherResonse;
    }
}
