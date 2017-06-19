package com.swayam.kotlintestapp.ui.activity

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import com.swayam.kotlintestapp.R

class SensorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensors)

        var tvSensors = findViewById(R.id.tvSensors) as TextView
        var sm : SensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        var sList = sm.getSensorList(Sensor.TYPE_ALL)

        for (s in sList){

            tvSensors.text = tvSensors.text.toString() + "\n" + s.name + "\n" + s.vendor + "\n" + s.version
        }

    }
}
