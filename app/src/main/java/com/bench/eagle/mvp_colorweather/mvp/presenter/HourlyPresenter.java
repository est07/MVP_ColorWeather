package com.bench.eagle.mvp_colorweather.mvp.presenter;

import com.bench.eagle.mvp_colorweather.mvp.model.HourlyModel;
import com.bench.eagle.mvp_colorweather.mvp.view.HourlyView;

public class HourlyPresenter {

    private HourlyView hourlyView;
    private HourlyModel hourlyModel;

    public HourlyPresenter(HourlyModel hourlyModel, HourlyView hourlyView) {

        this.hourlyModel = hourlyModel;
        this.hourlyView = hourlyView;
        init();
    }

    private void init() {

        if (hourlyModel.getHourlyWeatherResonse()!=null){

            hourlyView.hideNoDataText();
            hourlyView.setDailyWeatherItems(hourlyModel.getHourlyWeatherResonse(), hourlyModel.getTimeZone());

        }else {
            hourlyView.showNoDataText();
        }

    }

}
