package com.bench.eagle.mvp_colorweather.ui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.WeatherData;
import com.bench.eagle.mvp_colorweather.adapters.DailyWeatherAdapter;
import com.bench.eagle.mvp_colorweather.mvp.model.DailyModel;
import com.bench.eagle.mvp_colorweather.mvp.model.MainModel;
import com.bench.eagle.mvp_colorweather.mvp.presenter.DailyPresenter;
import com.bench.eagle.mvp_colorweather.mvp.presenter.MainPresenter;
import com.bench.eagle.mvp_colorweather.mvp.view.DailyView;
import com.bench.eagle.mvp_colorweather.mvp.view.MainView;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;
import com.bench.eagle.mvp_colorweather.service.ServiceUtils;

import java.util.ArrayList;

import butterknife.ButterKnife;

public class DailyWeatherActivity extends AppCompatActivity {

    DailyPresenter presenter;

    private String timeZone;
    private ArrayList<DataWeatherResponse> days;

    public static Intent newInstanceExtra(Activity activity, String timezone, ArrayList<DataWeatherResponse> daily) {

        Intent dailyActivityIntent = new Intent(activity, DailyWeatherActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString(WeatherData.TIMEZONE, timezone);
        bundle.putParcelableArrayList(WeatherData.DAYS_ARRAY_LIST, daily);
        dailyActivityIntent.putExtras(bundle);

        return dailyActivityIntent;

    }

    public static Intent newInstanceExtra(Activity activity) {

        return new Intent(activity, DailyWeatherActivity.class);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_weather);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();

        if(bundle !=null) {
            timeZone = bundle.getString(WeatherData.TIMEZONE);
            days = bundle.getParcelableArrayList(WeatherData.DAYS_ARRAY_LIST);
        }

        presenter = new DailyPresenter(new DailyModel(days,timeZone),new DailyView(this));

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
