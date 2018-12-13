package com.bench.eagle.mvp_colorweather.mvp.model;

import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;

import java.util.ArrayList;

public class MinutelyModel {

    private String timeZone;

    private ArrayList<DataWeatherResponse> minutelyWeatherResonse;

    public MinutelyModel(ArrayList<DataWeatherResponse> minutelyWeatherResonse, String timeZone) {
        this.minutelyWeatherResonse = minutelyWeatherResonse;
        this.timeZone = timeZone;
    }


    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public ArrayList<DataWeatherResponse> getMinutelyWeatherResonse() {
        return minutelyWeatherResonse;
    }

    public void setMinutelyWeatherResonse(ArrayList<DataWeatherResponse> minutelyWeatherResonse) {
        this.minutelyWeatherResonse = minutelyWeatherResonse;
    }
}
