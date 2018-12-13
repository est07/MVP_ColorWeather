package com.bench.eagle.mvp_colorweather.mvp.presenter;

import com.bench.eagle.mvp_colorweather.mvp.model.MinutelyModel;
import com.bench.eagle.mvp_colorweather.mvp.view.MinutelyView;

public class MinutelyPresenter {

    private MinutelyView minutelyView;
    private MinutelyModel minutelyModel;

    public MinutelyPresenter(MinutelyModel minutelyModel, MinutelyView minutelyView) {

        this.minutelyModel = minutelyModel;
        this.minutelyView = minutelyView;
        init();
    }

    private void init() {

        if (minutelyModel.getMinutelyWeatherResonse()!=null){

            minutelyView.hideNoDataText();
            minutelyView.setDailyWeatherItems(minutelyModel.getMinutelyWeatherResonse(), minutelyModel.getTimeZone());

        }else {
            minutelyView.showNoDataText();
        }

    }
}
