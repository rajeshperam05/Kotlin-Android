package com.swayam.kotlintestapp.ui.activity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.swayam.kotlintestapp.R;
import com.swayam.kotlintestapp.ui.services.GPSTracker;

public class LocationActivity extends AppCompatActivity {

    private GPSTracker gpsTracker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        if (ActivityCompat.checkSelfPermission(LocationActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(LocationActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        }

        gpsTracker = new GPSTracker(LocationActivity.this);

    }

    public void location(View view) {




        if (gpsTracker.isCanGetLocation()) {

            double lat = gpsTracker.getLatitude();
            double lon = gpsTracker.getLongitude();

            Toast.makeText(LocationActivity.this, lat + "\n" + lon , Toast.LENGTH_SHORT).show();
        }


    }
}
