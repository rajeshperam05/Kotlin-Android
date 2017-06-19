package com.swayam.kotlintestapp.ui.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.swayam.kotlintestapp.R
import com.swayam.kotlintestapp.storage.Contact
import com.swayam.kotlintestapp.storage.SQLiteContactsDatabase

/**
 * Created by rajesh on 14/6/17.
 */

class ContactAdapter(context : Context?, arrayList: ArrayList<Contact>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var context = context
    var list = arrayList

    fun updateList(array : ArrayList<Contact>?){

        if (!array!!.isEmpty()){
            this.list!!.addAll(array)
            notifyDataSetChanged()
        }

    }

    fun refreshList(array : ArrayList<Contact>?){

        if (!array!!.isEmpty()){
            this.list!!.clear()
            this.list!!.addAll(array)
            notifyDataSetChanged()
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {

        var view : View = LayoutInflater.from(context).inflate(R.layout.home_adapter_recycler_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        val view = holder as MyViewHolder

        view.tvHome.text = list!![position].name

//        view.itemView.setOnClickListener {v -> kotlin.run {
//
//            var db : SQLiteContactsDatabase = SQLiteContactsDatabase(context)
//            db.delete(list!![position].id!!)
//            list!!.removeAt(position)
//            notifyDataSetChanged()
//
//        }  }

        view.itemView.setOnLongClickListener {v -> kotlin.run {
            var db : SQLiteContactsDatabase = SQLiteContactsDatabase(context)
            db.delete(list!![position].id!!)
            list!!.removeAt(position)
            notifyDataSetChanged()
            true
        } }


    }

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var tvHome = itemView?.findViewById(R.id.tvHome) as TextView

    }

}