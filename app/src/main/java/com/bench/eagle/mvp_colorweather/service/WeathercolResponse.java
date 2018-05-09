
package com.bench.eagle.mvp_colorweather.service;


import com.bench.eagle.mvp_colorweather.models.CurrentWeather;
import com.bench.eagle.mvp_colorweather.models.Day;
import com.bench.eagle.mvp_colorweather.models.Hour;
import com.bench.eagle.mvp_colorweather.models.Minute;
import com.google.gson.annotations.SerializedName;

public class WeathercolResponse {

    @SerializedName("currently")
    private CurrentWeather current;
    @SerializedName("minutely")
    private Minute minute;
    @SerializedName("hourly")
    private Hour hour;
    @SerializedName("daily")
    private Day day;

    public CurrentWeather getCurrent() {
        return current;
    }

    public void setCurrent(CurrentWeather current) {
        this.current = current;
    }

    public Minute getMinute() {
        return minute;
    }

    public void setMinute(Minute minute) {
        this.minute = minute;
    }

    public Hour getHour() {
        return hour;
    }

    public void setHour(Hour hour) {
        this.hour = hour;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }


}
