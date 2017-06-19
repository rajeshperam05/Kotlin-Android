package com.swayam.kotlintestapp.ui.activity

import android.view.ViewGroup

class SecondActivity : android.support.v7.app.AppCompatActivity() {

    override fun onCreate(savedInstanceState: android.os.Bundle?) {
        super.onCreate(savedInstanceState)

        var data = intent.getStringExtra("Test")

        var params = android.view.ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        var textView = android.widget.TextView(this)
        textView.layoutParams = params
        setContentView(textView)


        var listData = arrayListOf<String>()
        listData.add(data)

        for (n in 1..200){
            listData.add(n.toString())
        }

        listData.reverse()

        var result : String = ""

        listData.forEach { it -> result = it+"$result \n" }

        textView.text = result

    }
}
