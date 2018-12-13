package com.bench.eagle.mvp_colorweather.mvp.model;

import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;

import java.util.ArrayList;

public class DailyModel {

    private String timeZone;

    private ArrayList<DataWeatherResponse> dailyWeatherResonse;

    public DailyModel(ArrayList<DataWeatherResponse> dailyWeatherResonse, String timeZone) {
        this.dailyWeatherResonse = dailyWeatherResonse;
        this.timeZone = timeZone;
    }


    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public ArrayList<DataWeatherResponse> getDailyWeatherResonse() {
        return dailyWeatherResonse;
    }

    public void setDailyWeatherResonse(ArrayList<DataWeatherResponse> dailyWeatherResonse) {
        this.dailyWeatherResonse = dailyWeatherResonse;
    }
}
