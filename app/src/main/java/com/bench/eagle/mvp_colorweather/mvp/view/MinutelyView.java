package com.bench.eagle.mvp_colorweather.mvp.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.adapters.MinutelyWeatherAdapter;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;
import com.bench.eagle.mvp_colorweather.ui.ActivityView;
import com.bench.eagle.mvp_colorweather.ui.MinutelyWeatherActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MinutelyView extends ActivityView<MinutelyWeatherActivity> {

    @BindView(R.id.minutelyRecyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.minutelyNoDataTextView)
    TextView noDataTextView;

    private MinutelyWeatherAdapter adapter;

    public MinutelyView(MinutelyWeatherActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setDailyWeatherItems(ArrayList<DataWeatherResponse> minutely, String timeZone){

        adapter = new MinutelyWeatherAdapter(getContext(),minutely,timeZone);
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
