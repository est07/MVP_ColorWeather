
package com.bench.eagle.mvp_colorweather.service;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Hourly {

    @SerializedName("data")
    private List<DataWeatherResponse> data;
    @SerializedName("icon")
    private String icon;
    @SerializedName("summary")
    private String summary;

    public List<DataWeatherResponse> getData() {
        return data;
    }

    public void setData(List<DataWeatherResponse> data) {
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
