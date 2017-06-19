package com.swayam.kotlintestapp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.swayam.kotlintestapp.R

class MainActivity : AppCompatActivity() {

    var etFirstNumber : EditText? = null
    var etSecondNumber : EditText? = null
    var btnPlus : Button? = null
    var btnMinus : Button? = null
    var tvResult : TextView? = null

    var number = 0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeViews()

        btnPlus?.setOnClickListener { v ->
            run {

                val numberOne = etFirstNumber?.getText().toString()
                val secondNumber = etSecondNumber?.getText().toString()

                if (!TextUtils.isDigitsOnly(numberOne) && !TextUtils.isDigitsOnly(secondNumber)) {
                    val result: Int = numberOne.toInt() + secondNumber.toInt()
                }


                tvResult?.setText("${number++}")

            }
        }

        btnMinus?.setOnClickListener { v: View? -> run {

            val numberOne = etFirstNumber?.text.toString()
            val secondNumber = etSecondNumber?.text.toString()

            tvResult?.text = "${number--}"
        } }

        tvResult?.setOnClickListener { v -> run {

            var intent = Intent(this@MainActivity, SecondActivity().javaClass)
            intent.putExtra("Test", "test Raj")
            startActivity(intent)
        } }

    }

    fun initializeViews() {

        etFirstNumber = findViewById(R.id.etFirstNumber) as EditText?
        etSecondNumber = findViewById(R.id.etSecondNumber) as EditText?
        btnPlus = findViewById(R.id.btnPlus) as Button?
        btnMinus = findViewById(R.id.btnMinus) as Button?
        tvResult = findViewById(R.id.tvResult) as TextView?

    }

}


