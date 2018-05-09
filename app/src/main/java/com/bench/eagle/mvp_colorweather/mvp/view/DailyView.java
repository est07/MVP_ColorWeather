package com.bench.eagle.mvp_colorweather.mvp.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.adapters.DailyWeatherAdapter;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;
import com.bench.eagle.mvp_colorweather.ui.ActivityView;
import com.bench.eagle.mvp_colorweather.ui.DailyWeatherActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DailyView extends ActivityView<DailyWeatherActivity> {

    @BindView(R.id.dailyRecyclerView)
    RecyclerView recyclerView;

    private DailyWeatherAdapter adapter;

    public DailyView(DailyWeatherActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public void setDailyWeatherItems(ArrayList<DataWeatherResponse> daily){

        adapter = new DailyWeatherAdapter(getContext(),daily);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);

    }


}
