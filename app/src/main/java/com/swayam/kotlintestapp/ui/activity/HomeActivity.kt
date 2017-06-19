package com.swayam.kotlintestapp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.swayam.kotlintestapp.ui.adapter.HomeAdapter
import com.swayam.kotlintestapp.R

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var recyclerView = findViewById(R.id.recyclerView) as RecyclerView
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val arrayList = arrayListOf<String>()
        arrayList.add("Calculator")
        arrayList.add("XML Parser")
        arrayList.add("Wifi Connection")
        arrayList.add("WebView")
        arrayList.add("TextureView")
        arrayList.add("TextToSpech")
        arrayList.add("Contacts SQLite")
        arrayList.add("Contacts Preferences")
        arrayList.add("Sensors")
        arrayList.add("RSS Feed")
        arrayList.add("Notification")
        arrayList.add("Send SMS")
        arrayList.add("Location")

        var adapter = HomeAdapter(this@HomeActivity, arrayList)
        recyclerView.adapter = adapter

    }
}
