package com.bench.eagle.mvp_colorweather.mvp.presenter;


import com.bench.eagle.mvp_colorweather.mvp.model.MainModel;
import com.bench.eagle.mvp_colorweather.mvp.view.MainView;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;
import com.bench.eagle.mvp_colorweather.service.GetWeatherResponse;


import java.util.ArrayList;

import io.reactivex.observers.DisposableObserver;


public class MainPresenter {

    private MainModel mainModel;
    private MainView mainView;

    private ArrayList<DataWeatherResponse> daily;
    private String timeZone;


    public MainPresenter(MainModel mainModel, MainView mainView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
        init();
    }

    public void init() {


        mainModel.getWeathers(new DisposableObserver<GetWeatherResponse>() {
            @Override
            public void onNext(GetWeatherResponse results) {
                mainView.init(results);
                timeZone = results.getTimezone();
                daily= results.getDaily().getData();

            }

            @Override
            public void onError(Throwable e) {
                mainView.showError();
            }

            @Override
            public void onComplete() {
            }
        });
    }

    public void showMessage(String caracterName) {
        mainView.showMessage(caracterName);
    }

    public void dailyWeatherClick() {
        mainView.dailyWeatherClick(timeZone, daily);
    }

    /*@Subscribe
    public void onItemsSuccessEvent(GetItemsSuccessEvent event) {
        caracterView.setAdapter(new CaracterAdapter(event.getItemList()));
    }*/

}
