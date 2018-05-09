package com.bench.eagle.mvp_colorweather.utils;


import android.content.Context;
import android.widget.Toast;

import com.bench.eagle.mvp_colorweather.R;


public class ToastServices {


    public static void errorResponseDataService(Context context){

        if (context != null) {

            Toast.makeText(context, R.string.error_data_null, Toast.LENGTH_SHORT).show();

        }else{

            return;

        }
    }

    public static void errorResponseConectionService(Context context){

        if(context!=null) {

            Toast.makeText(context, R.string.error_network, Toast.LENGTH_SHORT).show();

        }else {

            return;

        }
    }

}
