package com.bench.eagle.mvp_colorweather.models;


import com.google.gson.annotations.SerializedName;

public class WeatherResponse <T>{


    private double latitud;
    private double longitude;
    private String timeZone;
    private T day;
    private T hour;
    private T minute;
    @SerializedName("currently")
    private T currently;


    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public T getCurrently() {
        return currently;
    }

    public void setCurrently(T currently) {
        this.currently = currently;
    }

    public T getDay() {
        return day;
    }

    public void setDay(T day) {
        this.day = day;
    }

    public T getHour() {
        return hour;
    }

    public void setHour(T hour) {
        this.hour = hour;
    }

    public T getMinute() {
        return minute;
    }

    public void setMinute(T minute) {
        this.minute = minute;
    }

}
