package com.bench.eagle.mvp_colorweather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.models.Day;
import com.bench.eagle.mvp_colorweather.service.DataWeatherResponse;

import java.util.ArrayList;


public class DailyWeatherAdapter extends RecyclerView.Adapter<DailyWeatherAdapter.DailyViewHolder> {

//    public static final String TAG = DailyWeatherAdapter.class.getSimpleName();

    private ArrayList<DataWeatherResponse> days;
    private Context context;

    public DailyWeatherAdapter(Context context, ArrayList<DataWeatherResponse> days){

        this.context = context;
        this.days = days;

    }

    @Override
    public DailyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.daily_list_item,parent,false);

        return new DailyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DailyViewHolder holder, int position) {

        DataWeatherResponse day = days.get(position);
        holder.onBind(day);
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

            dayTitle = (TextView) itemView.findViewById(R.id.dailyListTitle);
            dayDescription = (TextView) itemView.findViewById(R.id.dailyListDescription);
            dayRainProbability = (TextView) itemView.findViewById(R.id.dailyListProbability);

        }

        public void onBind(final DataWeatherResponse day){


            /*String dayName =  dateFormat.format(jsonWithDayData.getDouble(TIME)*1000);
            dateFormat.format(jsonWithDayData.getDouble(TIME)*1000
            dayTitle.setText((day.getDayName()));*/
            dayDescription.setText(day.getSummary());
            dayRainProbability.setText(String.valueOf(day.getPrecipProbability()));
        }
    }

    /*public DailyWeatherAdapter (Context context, ArrayList<Day> days){

        this.context = context;
        this.days=days;

    }


    @Override
    public int getCount() {

        if (days == null)
            return 0;

        return days.size();
    }

    @Override
    public Object getItem(int position) {

        return days.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;

        Day day = days.get(position);

        if (view == null) {

            view = LayoutInflater.from(context).inflate(R.layout.daily_list_item, viewGroup,false);

            viewHolder = new ViewHolder();
            viewHolder.dayTitle = (TextView) view.findViewById(R.id.dailyListTitle);
            viewHolder.dayDescription = (TextView) view.findViewById(R.id.dailyListDescription);
            viewHolder.dayRainProbability = (TextView) view.findViewById(R.id.dailyListProbability);

            view.setTag(viewHolder);
        }else{

            viewHolder = (ViewHolder) view.getTag();
        }



        viewHolder.dayTitle.setText(day.getDayName());
        viewHolder.dayDescription.setText(day.getWeatherDescription());
        viewHolder.dayRainProbability.setText(day.getRainProbability());

        return view;
    }

    static class ViewHolder{

        TextView dayTitle;
        TextView dayDescription;
        TextView dayRainProbability;


    }*/



}
