package com.bench.eagle.mvp_colorweather.mvp.view;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.adapters.DailyWeatherAdapter;
import com.bench.eagle.mvp_colorweather.service.Currently;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;
import com.bench.eagle.mvp_colorweather.service.GetWeatherResponse;
import com.bench.eagle.mvp_colorweather.ui.ActivityView;
import com.bench.eagle.mvp_colorweather.ui.DailyWeatherActivity;
import com.bench.eagle.mvp_colorweather.ui.HourlyWeatherActivity;
import com.bench.eagle.mvp_colorweather.ui.MainActivity;
import com.bench.eagle.mvp_colorweather.ui.MinutelyWeatherActivity;
import com.bench.eagle.mvp_colorweather.utils.SharedPreferences;


import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;


public class MainView extends ActivityView<MainActivity> {

    @BindView(R.id.iconImageView)
    ImageView iconImageView;
    @BindView(R.id.descriptionTextView)
    TextView descriptionTextView;
    @BindView(R.id.currentTempTextView)
    TextView currentTempTextView;
    @BindView(R.id.highestTemTextView)
    TextView highestTemTextView;
    @BindView(R.id.lowestTemTextView)
    TextView lowestTemTextView;

    @BindView(R.id.dailyWeathertextView)
    TextView btnDailyWeatherActvity;
    @BindView(R.id.hourlyWeatherTextView)
    TextView btnHourlyWeatherActvity;
    @BindView(R.id.minutelyWeatherTextView)
    TextView btnMinutelyWeatherActvity;

    @BindString(R.string.error_connection_webservice) String errorMessge;


    public static final String CLEAR_NIGHT = "clear-night";
    public static final String CLEAR_DAY = "clear-day";
    public static final String CLOUDY = "cloudy";
    public static final String PARTLY_CLOUDY_NIGHT = "partly-cloudy-night";
    public static final String FOG = "fog";
    public static final String NA = "na";
    public static final String PARTLY_CLOUDY_DAY = "partly-cloudy-day";
    public static final String RAIN = "rain";
    public static final String SLEET = "sleet";
    public static final String SNOW = "snow";
    public static final String SUNNY = "sunny";
    public static final String WIND = "wind";

    private String iconImage;

    ArrayList<DataWeatherResponse> days;


    @BindDrawable(R.drawable.clear_night) Drawable clearNight;
    @BindDrawable(R.drawable.clear_day) Drawable clearDay;
    @BindDrawable(R.drawable.cloudy) Drawable cloudy;
    @BindDrawable(R.drawable.cloudy_night) Drawable cloudyNight;
    @BindDrawable(R.drawable.fog) Drawable fog;
    @BindDrawable(R.drawable.na) Drawable na;
    @BindDrawable(R.drawable.partly_cloudy) Drawable partlyCloudy;
    @BindDrawable(R.drawable.rain) Drawable rain;
    @BindDrawable(R.drawable.sleet) Drawable sleet;
    @BindDrawable(R.drawable.snow) Drawable snow;
    @BindDrawable(R.drawable.sunny) Drawable sunny;
    @BindDrawable(R.drawable.wind) Drawable wind;


    public MainView(MainActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);

    }

    public void init(GetWeatherResponse getWeatherResponse) {

        Currently currentWeather = getWeatherResponse.getCurrently();
        days = getWeatherResponse.getDaily().getData();

        iconImage = currentWeather.getIcon();
        iconImageView.setImageDrawable(getIconDrawableResource());
        descriptionTextView.setText(currentWeather.getSummary());
        currentTempTextView.setText(String.valueOf(currentWeather.getTemperature()));
        highestTemTextView.setText(String.format("H: %s%%", currentWeather.getHumidity()));
        lowestTemTextView.setText(String.format("P: %s%%", currentWeather.getPrecipProbability()));

    }

    public Drawable getIconDrawableResource() {

        switch (iconImage) {
            case CLEAR_NIGHT:
                return clearNight;
            case CLEAR_DAY:
                return clearDay;
            case CLOUDY:
                return cloudy;
            case PARTLY_CLOUDY_NIGHT:
                return cloudyNight;
            case FOG:
                return fog;
            case NA:
                return na;
            case PARTLY_CLOUDY_DAY:
                return partlyCloudy;
            case RAIN:
                return rain;
            case SLEET:
                return sleet;
            case SNOW:
                return snow;
            case SUNNY:
                return sunny;
            case WIND:
                return wind;
            default:
                return na;

        }
    }

    public String getDataLocationSharedPreferences(){

        SharedPreferences sharedPreferences = new SharedPreferences(getContext());
        return sharedPreferences.getDataLocation();
    }

    public void showError() {
        Toast.makeText(getContext(), errorMessge, Toast.LENGTH_SHORT).show();
    }

    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }



    public void dailyWeatherClick(String timeZone, ArrayList<DataWeatherResponse> daily){

        Activity activity = getActivity();
        if (activity== null){
            return;
        }

        Objects.requireNonNull(getContext()).startActivity(DailyWeatherActivity.newInstanceExtra(activity,timeZone, daily));

    }


    public void hourlyWeatherClick(String timeZone, ArrayList<DataWeatherResponse> hourly){

        Activity activity = getActivity();
        if (activity== null){
            return;
        }

        Objects.requireNonNull(getContext()).startActivity(HourlyWeatherActivity.newInstanceExtra(activity,timeZone, hourly));

    }

    public void minutelyWeatherClick(String timeZone, ArrayList<DataWeatherResponse> minutely){

        Activity activity = getActivity();
        if (activity== null){
            return;
        }

        Objects.requireNonNull(getContext()).startActivity(MinutelyWeatherActivity.newInstanceExtra(activity,timeZone, minutely));

    }

}
