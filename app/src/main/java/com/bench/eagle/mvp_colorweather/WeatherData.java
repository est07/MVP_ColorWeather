package com.bench.eagle.mvp_colorweather;


import com.bench.eagle.mvp_colorweather.models.Day;
import com.bench.eagle.mvp_colorweather.models.Hour;
import com.bench.eagle.mvp_colorweather.models.Minute;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.TimeZone;

public class WeatherData {


    public static final String DATA = "data";
    public static final String SUMMARY = "summary";
    public static final String ICON = "icon";
    public static final String TEMPERATURE = "temperature";
    public static final String TEMPERATURE_MAX = "temperatureMax";
    public static final String TEMPERATURE_MIN = "temperatureMin";
    public static final String PRECIP_PROBABILITY = "precipProbability";
    public static final String TIME = "time";
    public static final String CURRENTLY = "currently";
    public static final String DAILY = "daily";
    public static final String HOURLY = "hourly";
    public static final String MINUTELY = "minutely";
    public static final String TIMEZONE = "timezone";
    public static final String DAYS_ARRAY_LIST = "DAYS_ARRAY_LIST";
    public static final String HOUR_ARRAY_LIST = "HOUR_ARRAY_LIST";
    public static final String MINUTE_ARRAY_LIST = "MINUTE_ARRAY_LIST";

    ArrayList<Day> days;
    ArrayList<Hour> hours;
    ArrayList<Minute>  minutes;


    /*public CurrentWeather getCurrentWeatherFromJson(String json, Activity activity) throws JSONException {


        JSONObject jsonObject = new JSONObject(json);

        JSONObject jsonWithCurrentWeather = jsonObject.getJSONObject(CURRENTLY);
        JSONObject jsonWithDailyWeather = jsonObject.getJSONObject(DAILY);
        JSONArray jsonWithDailyWeatherData = jsonWithDailyWeather.getJSONArray(DATA);

        JSONObject jsonWithTodayData = jsonWithDailyWeatherData.getJSONObject(0);

        String summary = jsonWithCurrentWeather.getString(SUMMARY);
        String icon = jsonWithCurrentWeather.getString(ICON);
        String temperature = Math.round(jsonWithCurrentWeather.getDouble(TEMPERATURE)) + "";

        String maxTemperature = Math.round(jsonWithTodayData.getDouble(TEMPERATURE_MAX)) + "";
        String minTemperature = Math.round(jsonWithTodayData.getDouble(TEMPERATURE_MIN)) + "";

        CurrentWeather currentWeather = new CurrentWeather();
        currentWeather.setDescription(summary);
        currentWeather.setIconImage(icon);
        currentWeather.setCurrentTemperature(temperature);
        currentWeather.setHighestTemperature(maxTemperature);
        currentWeather.setLowestTemperature(minTemperature);

        return  currentWeather;
    }*/

    private ArrayList<Day> getDailyWeatherFromJson(String json)throws JSONException{

        DateFormat dateFormat = new SimpleDateFormat("EEEE");

        ArrayList<Day> days = new ArrayList<Day>();

        JSONObject jsonObject = new JSONObject(json);

        String timeZone = jsonObject.getString(TIMEZONE);

        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        JSONObject jsonWithDailyWeather = jsonObject.getJSONObject(DAILY);
        JSONArray  jsonWithDailyWeatherData = jsonWithDailyWeather.getJSONArray(DATA);

        for (int i = 0; i< jsonWithDailyWeatherData.length(); i++){

            Day day = new Day();

            JSONObject jsonWithDayData = jsonWithDailyWeatherData.getJSONObject(i);

            String rainProbability = "Rain probability: " + jsonWithDayData.getDouble(PRECIP_PROBABILITY)*100 +"%";

            String description = jsonWithDayData.getString(SUMMARY);
            String dayName =  dateFormat.format(jsonWithDayData.getDouble(TIME)*1000);

            day.setDayName(dayName);

            day.setRainProbability(rainProbability);
            day.setWeatherDescription(description);
            days.add(day);
        }

        return days;
    }


    public  ArrayList<Hour> getHourlyWeatherFromJson(String json)throws JSONException{

        DateFormat dateFormat = new SimpleDateFormat("HH: mm");

        ArrayList<Hour> hours = new ArrayList<Hour>();

        JSONObject jsonObject = new JSONObject(json);

        String timeZone = jsonObject.getString(TIMEZONE);

        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        JSONObject jsonWithHourlyWeather = jsonObject.getJSONObject(HOURLY);
        JSONArray  jsonWithHourlyWeatherData = jsonWithHourlyWeather.getJSONArray(DATA);

        for (int i = 0; i< jsonWithHourlyWeatherData.length();i++){

            Hour hour = new Hour();

            JSONObject jsonWithHourData = jsonWithHourlyWeatherData.getJSONObject(i);

            String title = dateFormat.format(jsonWithHourData.getDouble(TIME)*1000);
            String description = jsonWithHourData.getString(SUMMARY);

            hour.setTitle(title);
            hour.setWeatherDescription(description);

            hours.add(hour);

        }


        return hours;
    }

    public ArrayList<Minute> getMinutelyWeatherFromJson(String json) throws JSONException{

        DateFormat dateFormat = new SimpleDateFormat("HH: mm");

        ArrayList<Minute> minutes = new ArrayList<Minute>();

        JSONObject jsonObject = new JSONObject(json);

        String timeZone = jsonObject.getString(TIMEZONE);

        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        JSONObject jsonWithMinutelyWeather = jsonObject.getJSONObject(MINUTELY);
        JSONArray  jsonWithMinutelyWeatherData = jsonWithMinutelyWeather.getJSONArray(DATA);

        for (int i = 0; i < jsonWithMinutelyWeatherData.length();i++){

            Minute minute = new Minute();

            JSONObject jsonWithMinuteData = jsonWithMinutelyWeatherData.getJSONObject(i);

            String title = dateFormat.format(jsonWithMinuteData.getDouble(TIME)*1000);
            String precipProbability =  "Rain probability: " + jsonWithMinuteData.getDouble(PRECIP_PROBABILITY)*100 + "%";

            minute.setTitle(title);
            minute.setRainProbability(precipProbability);

            minutes.add(minute);

        }

        return minutes;

    }

}
