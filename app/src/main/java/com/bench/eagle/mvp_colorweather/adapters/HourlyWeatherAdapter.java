package com.bench.eagle.mvp_colorweather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;
import com.bench.eagle.mvp_colorweather.utils.Dates;

import java.util.ArrayList;

import butterknife.ButterKnife;


public class HourlyWeatherAdapter extends RecyclerView.Adapter<HourlyWeatherAdapter.HourlyViewHolder> {

    ArrayList<DataWeatherResponse> hours;
    private String timeZone;
    private Context context;

    public HourlyWeatherAdapter(Context context, ArrayList<DataWeatherResponse> hours, String timeZone) {

        this.context = context;
        this.hours = hours;
        this.timeZone = timeZone;
    }

    @Override
    public HourlyWeatherAdapter.HourlyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.hourly_list_item, parent, false);

        return new HourlyWeatherAdapter.HourlyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HourlyWeatherAdapter.HourlyViewHolder holder, int position) {

        DataWeatherResponse hour = hours.get(position);
        holder.onBind(hour, timeZone);
    }

    @Override
    public int getItemCount() {

        if (hours == null)
            return 0;

        return hours.size();
    }

    public static class HourlyViewHolder extends RecyclerView.ViewHolder {

        TextView hourTitle;
        TextView hourDescription;

        HourlyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            hourTitle = (TextView) itemView.findViewById(R.id.hourlyTitleTextView);
            hourDescription = (TextView) itemView.findViewById(R.id.hourlyDescriptionTextView);

        }

        public void onBind(final DataWeatherResponse hour, final String timeZone) {

            hourTitle.setText(Dates.getHour(timeZone, hour.getTime()));
            hourDescription.setText(hour.getSummary());

        }
    }

}