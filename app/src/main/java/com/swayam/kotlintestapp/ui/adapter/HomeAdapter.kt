package com.swayam.kotlintestapp.ui.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.swayam.kotlintestapp.*
import com.swayam.kotlintestapp.ui.activity.*

/**
 * Created by rajesh on 12/6/17.
 */

class HomeAdapter(context : Context?, arrayList: ArrayList<String>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var context = context
    var arrayList = arrayList


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        var view : View = LayoutInflater.from(context).inflate(R.layout.home_adapter_recycler_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        val view = holder as MyViewHolder

        view.tvHome.text = arrayList!![position]

        view.itemView.setOnClickListener { v -> run {

            when(position){

                0 -> {
                    (context as Activity).startActivity(Intent(context, MainActivity().javaClass))
                }

                1 -> {
                    (context as Activity).startActivity(Intent(context, XmlParserActivity().javaClass))
                }

                2 -> {
                    (context as Activity).startActivity(Intent(context, WifiActivity().javaClass))
                }

                3 -> {
                    (context as Activity).startActivity(Intent(context, WebViewActivity().javaClass))
                }

                4 -> {
                    (context as Activity).startActivity(Intent(context, TextureViewActivity().javaClass))
                }

                5-> {
                    (context as Activity).startActivity(Intent(context, TextToSpeachActivity().javaClass))
                }

                6-> {
                    (context as Activity).startActivity(Intent(context, SQLiteDatabaseActivity().javaClass))
                }

                7-> {
                    (context as Activity).startActivity(Intent(context, ContactPreferencesActivity().javaClass))
                }

                8-> {
                    (context as Activity).startActivity(Intent(context, SensorsActivity().javaClass))
                }

                9-> {
                    (context as Activity).startActivity(Intent(context, RSSFeedActivity().javaClass))
                }

                10-> {
                    (context as Activity).startActivity(Intent(context, NotificationActivity().javaClass))
                }

                11-> {
                    (context as Activity).startActivity(Intent(context, SMSActivity().javaClass))
                }

                12-> {
                    (context as Activity).startActivity(Intent(context, LocationActivity().javaClass))
                }
            }
        } }


    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var tvHome = itemView?.findViewById(R.id.tvHome) as TextView

    }

}