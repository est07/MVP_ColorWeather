
package com.bench.eagle.mvp_colorweather.service;

import android.os.Parcel;
import android.os.Parcelable;


public class DataWeatherResponse implements Parcelable {

    private String summary;
    private Long time;
    private Double precipProbability;

    protected DataWeatherResponse(Parcel in) {
        summary = in.readString();
        if (in.readByte() == 0) {
            time = null;
        } else {
            time = in.readLong();
        }
        if (in.readByte() == 0) {
            precipProbability = null;
        } else {
            precipProbability = in.readDouble();
        }
    }

    public static final Creator<DataWeatherResponse> CREATOR = new Creator<DataWeatherResponse>() {
        @Override
        public DataWeatherResponse createFromParcel(Parcel in) {
            return new DataWeatherResponse(in);
        }

        @Override
        public DataWeatherResponse[] newArray(int size) {
            return new DataWeatherResponse[size];
        }
    };

    public Double getPrecipProbability() {
        return precipProbability;
    }

    public void setPrecipProbability(Double precipProbability) {
        this.precipProbability = precipProbability;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(summary);
        if (time == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeLong(time);
        }
        if (precipProbability == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeDouble(precipProbability);
        }
    }
}
