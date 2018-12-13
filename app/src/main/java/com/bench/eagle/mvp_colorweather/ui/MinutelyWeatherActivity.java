package com.bench.eagle.mvp_colorweather.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.WeatherData;
import com.bench.eagle.mvp_colorweather.mvp.model.HourlyModel;
import com.bench.eagle.mvp_colorweather.mvp.model.MinutelyModel;
import com.bench.eagle.mvp_colorweather.mvp.presenter.HourlyPresenter;
import com.bench.eagle.mvp_colorweather.mvp.presenter.MinutelyPresenter;
import com.bench.eagle.mvp_colorweather.mvp.view.HourlyView;
import com.bench.eagle.mvp_colorweather.mvp.view.MinutelyView;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class MinutelyWeatherActivity extends AppCompatActivity {

    MinutelyPresenter presenter;

    private String timeZone;
    private ArrayList<DataWeatherResponse> minutes;

    public static Intent newInstanceExtra(Activity activity, String timezone, ArrayList<DataWeatherResponse> minutely) {

        Intent minutelyActivityIntent = new Intent(activity, MinutelyWeatherActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(WeatherData.TIMEZONE, timezone);
        bundle.putParcelableArrayList(WeatherData.MINUTE_ARRAY_LIST, minutely);
        minutelyActivityIntent.putExtras(bundle);

        return minutelyActivityIntent;

    }

    public static Intent newInstanceExtra(Activity activity) {

        return new Intent(activity, MinutelyWeatherActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minutely_weather);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        if(bundle !=null) {
            timeZone = bundle.getString(WeatherData.TIMEZONE);
            minutes = bundle.getParcelableArrayList(WeatherData.MINUTE_ARRAY_LIST);
        }

        presenter = new MinutelyPresenter(new MinutelyModel(minutes,timeZone),new MinutelyView(this));

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
