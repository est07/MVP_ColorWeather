package com.bench.eagle.mvp_colorweather.service.api;

/**
 * Created by andresdavid on 15/01/17.
 */

public class CostantsApi {

    public static final String BASE_URL ="https://api.darksky.net/forecast/d5ef0c0795745ad537d736156d3118e7/";
    public static final String APIKEY = "d5ef0c0795745ad537d736156d3118e7/";
    public static final String LATITUDE = "37.8267";
    public static final String LONGITUDE = ",-122.4233";
    public static final String UNITS_SI = "si";
    public static final String DATAUBICACION= LATITUDE+LONGITUDE+UNITS_SI;

    public static final String VERSION = "/v1";
    public static final String API_TYPE = "/public";
    public static final String SECTION = "/characters";
    public static final String PRIVATE_API_KEY_ARG = "apikey";
    public static final String PUBLIC_API_KEY_ARG = "hash";
    public static final String PRIVATE_API_KEY_VALUE = "ef2a724aba13278f85950382cf8a6baf";
    public static final String PUBLIC_API_KEY_VALUE = "317dfc7e823c9ee5e9f6148254fbdd34";
    public static final String TS= "ts";
    public static final String TS_VALUE= "1";

    public static final String querry =VERSION+API_TYPE+SECTION;
}
