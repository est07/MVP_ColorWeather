package com.bench.eagle.mvp_colorweather.mvp.presenter;

import com.bench.eagle.mvp_colorweather.mvp.view.DailyView;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;

import java.util.ArrayList;

public class DailyPresenter {

    private DailyView dailyView;

    private ArrayList<DataWeatherResponse> daily;

    public DailyPresenter(DailyView dailyView) {
        this.dailyView = dailyView;

    }

}
