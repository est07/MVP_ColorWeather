package com.bench.eagle.mvp_colorweather.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class Dates {

    public static String  getDay(String timeZone, Long time)
    {

        DateFormat dateFormat = new SimpleDateFormat("EEEE");
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        return dateFormat.format((time)*1000);
    }

    public static String  getHour(String timeZone, Long time)
    {

        DateFormat dateFormat = new SimpleDateFormat("HH: mm");
        dateFormat.setTimeZone(TimeZone.getTimeZone(timeZone));

        return dateFormat.format((time)*1000);
    }
}
