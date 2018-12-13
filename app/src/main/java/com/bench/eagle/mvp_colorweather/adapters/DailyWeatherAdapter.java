package com.bench.eagle.mvp_colorweather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.models.Day;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;
import com.bench.eagle.mvp_colorweather.utils.Dates;
import com.jakewharton.rxbinding.view.RxView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.subjects.PublishSubject;


public class DailyWeatherAdapter extends RecyclerView.Adapter<DailyWeatherAdapter.DailyViewHolder> {

    ArrayList<DataWeatherResponse> days;
    private String timeZone;
    private Context context;

    public DailyWeatherAdapter(Context context, ArrayList<DataWeatherResponse> days, String timeZone){

        this.context = context;
        this.days = days;
        this.timeZone = timeZone;
    }

    @Override
    public DailyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.daily_list_item,parent,false);

        return new DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DailyViewHolder holder, int position) {

        DataWeatherResponse day = days.get(position);
        holder.onBind(day, timeZone);
    }

    @Override
    public int getItemCount() {

        if (days==null)
        return 0;

        return days.size();
    }

    public static class DailyViewHolder extends RecyclerView.ViewHolder{

        TextView dayTitle;
        TextView dayDescription;
        TextView dayRainProbability;

        DailyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            dayTitle = (TextView) itemView.findViewById(R.id.dailyListTitle);
            dayDescription = (TextView) itemView.findViewById(R.id.dailyListDescription);
            dayRainProbability = (TextView) itemView.findViewById(R.id.dailyListProbability);

        }

        public void onBind(final DataWeatherResponse day, final String timeZone){

            dayTitle.setText(Dates.getDay(timeZone ,day.getTime()));
            dayDescription.setText(day.getSummary());
            dayRainProbability.setText(String.valueOf(day.getPrecipProbability()));
        }
    }

}
