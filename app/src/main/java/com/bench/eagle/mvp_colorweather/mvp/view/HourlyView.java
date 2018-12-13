package com.bench.eagle.mvp_colorweather.mvp.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.adapters.HourlyWeatherAdapter;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;
import com.bench.eagle.mvp_colorweather.ui.ActivityView;
import com.bench.eagle.mvp_colorweather.ui.HourlyWeatherActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourlyView extends ActivityView<HourlyWeatherActivity> {

    @BindView(R.id.hourlyRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.hourlyNoDataTextView)
    TextView noDataTextView;

    private HourlyWeatherAdapter adapter;

    public HourlyView(HourlyWeatherActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setDailyWeatherItems(ArrayList<DataWeatherResponse> hourly, String timeZone){

        adapter = new HourlyWeatherAdapter(getContext(),hourly,timeZone);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

    }

    public void hideNoDataText() {
        noDataTextView.setVisibility(View.GONE);
    }


    public void showNoDataText() {
        noDataTextView.setVisibility(View.VISIBLE);
    }



}
