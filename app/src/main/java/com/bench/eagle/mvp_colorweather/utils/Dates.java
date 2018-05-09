package com.bench.eagle.mvp_colorweather.utils;

import com.bench.eagle.mvp_colorweather.WeatherData;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class Dates {

    public static String  getDay()
    {

        DateFormat dateFormat = new SimpleDateFormat("EEEE");

       /* JSONObject jsonObject = new JSONObject(json);

        String timeZone = jsonObject.getString(WeatherData.TIMEZONE);



        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        String dayName =  dateFormat.format(jsonWithDayData.getDouble(WeatherData.TIME)*1000);*/
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
}
