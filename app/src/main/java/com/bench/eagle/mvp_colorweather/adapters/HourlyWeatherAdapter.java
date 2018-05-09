package com.bench.eagle.mvp_colorweather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.models.Hour;

import java.util.ArrayList;


public class HourlyWeatherAdapter extends RecyclerView.Adapter {

    ArrayList<Hour> hours;
    Context context;

    public HourlyWeatherAdapter (Context context, ArrayList<Hour> hours){

        this.context = context;
        this.hours=hours;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        if (hours == null)
            return 0;

        return hours.size();
    }


    class HourlyViewHolder extends RecyclerView.ViewHolder{

        TextView hourTitle;
        TextView hourDescription;

        public HourlyViewHolder(View itemView) {
            super(itemView);

            hourTitle = (TextView) itemView.findViewById(R.id.hourlyTitleTextView);
            hourDescription = (TextView) itemView.findViewById(R.id.hourlyDescriptionTextView);


        }

        public void onBind(int position){

            Hour hour = hours.get(position);

            hourTitle.setText(hour.getTitle());
            hourDescription.setText(hour.getWeatherDescription());
        }
    }

   /* @Override
    public int getCount() {

        if (hours == null)
            return 0;

        return hours.size();
    }

    @Override
    public Object getItem(int i) {

        return hours.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        Hour hour = hours.get(i);

        if (view == null) {

            view = LayoutInflater.from(context).inflate(R.layout.hourly_list_item, viewGroup,false);

            viewHolder = new ViewHolder();
            viewHolder.hourTitle = (TextView) view.findViewById(R.id.hourlyTitleTextView);
            viewHolder.hourDescription = (TextView) view.findViewById(R.id.hourlyDescriptionTextView);


            view.setTag(viewHolder);
        }else{

            viewHolder = (ViewHolder) view.getTag();
        }



        viewHolder.hourTitle.setText(hour.getTitle());
        viewHolder.hourDescription.setText(hour.getWeatherDescription());


        return view;
    }

    static class ViewHolder{

        TextView hourTitle;
        TextView hourDescription;

    }*/
}
