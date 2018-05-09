
package com.bench.eagle.mvp_colorweather.service;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Daily  {

    @SerializedName("data")
    private ArrayList<DataWeatherResponse> data;
    @SerializedName("icon")
    private String icon;
    @SerializedName("summary")
    private String summary;

    public ArrayList<DataWeatherResponse> getData() {
        return data;
    }

    public void setData(ArrayList<DataWeatherResponse> data) {
        this.data = data;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

}
