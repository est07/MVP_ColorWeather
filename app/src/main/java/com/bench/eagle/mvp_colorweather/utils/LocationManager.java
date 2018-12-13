package com.bench.eagle.mvp_colorweather.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.gson.Gson;


public class LocationManager implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {


    private static final String LOG_TAG = LocationManager.class.getName();
    private static final int INTERVAL_IN_MILLIS = 30000;
    private static final int FASTEST_INTERVAL_IN_MILLIS = 10000;
    private static final float MINIMUM_DISTANCE_CHANGE = 20;

    private static LocationManager locationManager;

    private Context context;
    private Activity activity;

    private GoogleApiClient googleApiClient;
    private LocationRequest locationRequest;
    private Location lastLocation;

    public static LocationManager getInstance(Activity activity) {
        if (locationManager == null) {
            locationManager = new LocationManager(activity);
        }
        return locationManager;
    }

    private LocationManager(Activity activity) {
        this.context = activity.getApplicationContext();
        this.activity = activity;
    }

    public synchronized void init() {
        createLocationRequest();

        googleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();

    }

    private void createLocationRequest() {
        locationRequest = new LocationRequest();
        locationRequest.setInterval(INTERVAL_IN_MILLIS);
        locationRequest.setSmallestDisplacement(MINIMUM_DISTANCE_CHANGE);
        locationRequest.setFastestInterval(FASTEST_INTERVAL_IN_MILLIS);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }


    public void startLocationUdates(){

        if (ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(context,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        Log.d(LOG_TAG, "onConnectedddd: ");
        LocationServices.FusedLocationApi.
                requestLocationUpdates(googleApiClient, locationRequest, this);

    }

    public void stopLocationUpdates() {
        if (isConnected()) {
            LocationServices.FusedLocationApi.
                    removeLocationUpdates(googleApiClient, this);
            disconnectGoogleApiClient();
        }
    }

    @Override
    public void onConnected(Bundle connectionHint) {

        if (isConnected()) {
            startLocationUdates();
        }

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(LOG_TAG, "onConnectedFaild: "+ connectionResult.getErrorMessage());
        connectGoogleApiClient();
    }

    @Override
    public void onConnectionSuspended(int i) {
        Log.d(LOG_TAG, "onConnectedSuspended: ");
        connectGoogleApiClient();
    }

    private void connectGoogleApiClient() {
        if (!isConnected()) {
            googleApiClient.connect();
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        lastLocation = location;
        saveLocation(lastLocation);
        stopLocationUpdates();
    }

    public void saveLocation(Location lastLocation) {

        String dataLocation = (lastLocation.getLatitude()+","+lastLocation.getLongitude());
        SharedPreferences sharedPreferences = new SharedPreferences(context);
        sharedPreferences.createDataLocation(dataLocation);

    }

    private boolean isConnected() {
        return googleApiClient != null && googleApiClient.isConnected();
    }

    public void disconnectGoogleApiClient() {
        if (isConnected()) {
            googleApiClient.disconnect();
        }
    }

}
