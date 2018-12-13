package com.bench.eagle.mvp_colorweather.mvp.presenter;

import com.bench.eagle.mvp_colorweather.mvp.model.DailyModel;
import com.bench.eagle.mvp_colorweather.mvp.view.DailyView;
import com.bench.eagle.mvp_colorweather.mvp.view.MainView;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;

import java.util.ArrayList;

public class DailyPresenter {

    private DailyView dailyView;
    private DailyModel dailyModel;

    public DailyPresenter(DailyModel dailyModel, DailyView dailyView) {

        this.dailyModel = dailyModel;
        this.dailyView = dailyView;
        init();
    }


    private void init() {

        if (dailyModel.getDailyWeatherResonse()!=null){

            dailyView.hideNoDataText();
            dailyView.setDailyWeatherItems(dailyModel.getDailyWeatherResonse(), dailyModel.getTimeZone());

        }else {
            dailyView.showNoDataText();
        }

    }

}
