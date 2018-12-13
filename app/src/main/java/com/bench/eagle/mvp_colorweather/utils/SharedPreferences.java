package com.bench.eagle.mvp_colorweather.utils;

import android.content.Context;


public class SharedPreferences extends BasePreferenceImpl {

    private static final String PREFERENCE_NAME = " LocationSharedPreferences";
    private static final String DATA_LOCATION = "dataLocation";


    public SharedPreferences(Context context) {
        super(context, PREFERENCE_NAME);
    }


    public void createDataLocation(String dataLocation){
        put(DATA_LOCATION, dataLocation);
    }

    public String getDataLocation() {
        return getString(DATA_LOCATION);
    }

    public void deleteDataLocation(){

        remove(DATA_LOCATION);
    }
}
