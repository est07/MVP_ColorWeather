package com.bench.eagle.mvp_colorweather.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.WeatherData;
import com.bench.eagle.mvp_colorweather.mvp.model.DailyModel;
import com.bench.eagle.mvp_colorweather.mvp.model.HourlyModel;
import com.bench.eagle.mvp_colorweather.mvp.presenter.DailyPresenter;
import com.bench.eagle.mvp_colorweather.mvp.presenter.HourlyPresenter;
import com.bench.eagle.mvp_colorweather.mvp.view.DailyView;
import com.bench.eagle.mvp_colorweather.mvp.view.HourlyView;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class HourlyWeatherActivity extends AppCompatActivity {

    HourlyPresenter presenter;

    private String timeZone;
    private ArrayList<DataWeatherResponse> hours;

    public static Intent newInstanceExtra(Activity activity, String timezone, ArrayList<DataWeatherResponse> hourly) {

        Intent hourlyActivityIntent = new Intent(activity, HourlyWeatherActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(WeatherData.TIMEZONE, timezone);
        bundle.putParcelableArrayList(WeatherData.HOUR_ARRAY_LIST, hourly);
        hourlyActivityIntent.putExtras(bundle);

        return hourlyActivityIntent;

    }

    public static Intent newInstanceExtra(Activity activity) {

        return new Intent(activity, HourlyWeatherActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_weather);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        if(bundle !=null) {
            timeZone = bundle.getString(WeatherData.TIMEZONE);
            hours = bundle.getParcelableArrayList(WeatherData.HOUR_ARRAY_LIST);
        }

        presenter = new HourlyPresenter(new HourlyModel(hours,timeZone),new HourlyView(this));

    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

}
