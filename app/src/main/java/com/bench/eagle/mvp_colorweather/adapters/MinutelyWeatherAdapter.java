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


public class MinutelyWeatherAdapter extends RecyclerView.Adapter<MinutelyWeatherAdapter.MinutelyViewHolder> {

    ArrayList<DataWeatherResponse> minutes;
    private String timeZone;
    private Context context;

    public MinutelyWeatherAdapter(Context context, ArrayList<DataWeatherResponse> minutes, String timeZone) {

        this.context = context;
        this.minutes = minutes;
        this.timeZone = timeZone;
    }

    @Override
    public MinutelyWeatherAdapter.MinutelyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.minutely_list_item, parent, false);

        return new MinutelyWeatherAdapter.MinutelyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MinutelyWeatherAdapter.MinutelyViewHolder holder, int position) {

        DataWeatherResponse minute = minutes.get(position);
        holder.onBind(minute, timeZone);
    }

    @Override
    public int getItemCount() {

        if (minutes == null)
            return 0;

        return minutes.size();
    }

    public static class MinutelyViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView rainProbabilityTextView;

        MinutelyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            titleTextView = (TextView) itemView.findViewById(R.id.minutelyTitleTextView);
            rainProbabilityTextView = (TextView) itemView.findViewById(R.id.minutelyRainProbabilityTextView);

        }

        public void onBind(final DataWeatherResponse minute, final String timeZone) {

            titleTextView.setText(Dates.getHour(timeZone, minute.getTime()));
            rainProbabilityTextView.setText(String.valueOf(minute.getPrecipProbability()));

        }
    }

}
