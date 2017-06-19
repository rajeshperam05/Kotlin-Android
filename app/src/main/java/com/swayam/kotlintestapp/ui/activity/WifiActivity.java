package com.swayam.kotlintestapp.ui.activity;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.swayam.kotlintestapp.R;

public class WifiActivity extends AppCompatActivity{

    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi);

        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

    }

    public void enable(View view){

        if (!wifiManager.isWifiEnabled())
        wifiManager.setWifiEnabled(true);

        Toast.makeText(getApplicationContext(), "Wifi Enabled", Toast.LENGTH_SHORT).show();

    }

    public void disable(View view){

        if (wifiManager.isWifiEnabled())
        wifiManager.setWifiEnabled(false);

        Toast.makeText(getApplicationContext(), "Wifi Disabled", Toast.LENGTH_SHORT).show();

    }

}
