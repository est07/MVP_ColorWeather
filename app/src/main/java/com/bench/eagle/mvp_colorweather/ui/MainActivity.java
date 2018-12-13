package com.bench.eagle.mvp_colorweather.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bench.eagle.mvp_colorweather.R;
import com.bench.eagle.mvp_colorweather.mvp.model.MainModel;
import com.bench.eagle.mvp_colorweather.mvp.presenter.MainPresenter;
import com.bench.eagle.mvp_colorweather.mvp.view.MainView;
import com.bench.eagle.mvp_colorweather.service.ServiceUtils;
import com.bench.eagle.mvp_colorweather.utils.LocationManager;
import com.bench.eagle.mvp_colorweather.utils.SharedPreferences;
import com.bench.eagle.mvp_colorweather.utils.Utils;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    MainPresenter presenter;
    private int ACCESS_FINE_LOCATION = 23;

    private String dataLoction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (Utils.isLocationPermissonAllowed(this)) {

            initLocationManager();
            initAcivity();

        } else {

            requestStoragePermission();
        }

    }

    private void initAcivity(){

        dataLoction = getDataSharedPreferences();

        presenter = new MainPresenter(new MainModel(ServiceUtils.getItemService(), dataLoction),new MainView(this));
        presenter.init();

    }



    @Override
    protected void onPause() {
        super.onPause();
    }
    @Override
    protected void onStop() {
        LocationManager.getInstance(this).stopLocationUpdates();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        deleteDataSharedPreferences();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!this.isGPSIsEnable())
            showInfoAlert();
    }

    @OnClick(R.id.dailyWeathertextView)
    public void dailyWeatherClick(){
        presenter.dailyWeatherClick();

    }

    @OnClick(R.id.hourlyWeatherTextView)
    public void hourlyWeatherClick(){
        presenter.hourlyWeatherClick();

    }

    @OnClick(R.id.minutelyWeatherTextView)
    public void minutelyWeatherClick(){
        presenter.minutelyWeatherClick();

    }

    private boolean isGPSIsEnable(){
        try {

            int gpsSignal = Settings.Secure.getInt(getContentResolver(), Settings.Secure.LOCATION_MODE);

            if(gpsSignal ==0){
                return false;
            }else {
                return true;
            }
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void showInfoAlert(){
        new AlertDialog.Builder(this)
                .setTitle("GPS Signal")
                .setMessage("El GPS no esta activo, desea activarlo.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("CANCEL", null)
                .show();
    }

    private void requestStoragePermission() {

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.ACCESS_FINE_LOCATION)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},
                        ACCESS_FINE_LOCATION);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (requestCode == ACCESS_FINE_LOCATION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initLocationManager();
                initAcivity();
            } else {
                Toast.makeText(this, R.string.error_no_accepted_permission, Toast.LENGTH_LONG).show();
            }
        }
    }

    private void deleteDataSharedPreferences(){
        SharedPreferences sharedPreferences = new SharedPreferences(this);
        sharedPreferences.deleteDataLocation();
    }

    private String getDataSharedPreferences(){

        SharedPreferences sharedPreferences = new SharedPreferences(this);
        return sharedPreferences.getDataLocation();
    }

    private void initLocationManager(){

        LocationManager.getInstance(this).init();
    }


}

