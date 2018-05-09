package com.bench.eagle.mvp_colorweather.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.mvp.model.MainModel;
import com.bench.eagle.mvp_colorweather.mvp.presenter.MainPresenter;
import com.bench.eagle.mvp_colorweather.mvp.view.MainView;
import com.bench.eagle.mvp_colorweather.service.ServiceUtils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new MainPresenter(new MainModel(ServiceUtils.getItemService()),new MainView(this));

        presenter.init();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @OnClick(R.id.dailyWeathertextView)
    public void dailyWeatherClick(){
        presenter.dailyWeatherClick();

    }
}
