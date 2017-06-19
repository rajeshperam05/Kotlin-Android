package com.swayam.kotlintestapp.ui.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.telephony.SmsManager
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast

import com.swayam.kotlintestapp.R
import java.security.Permission

class SMSActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)
    }

    fun send(View : View) {

        var etNumber : EditText = findViewById(R.id.etNumber) as EditText
        var etText : EditText = findViewById(R.id.etText) as EditText

        var num = etNumber.text.toString()
        var body = etText.text.toString()

        if (!TextUtils.isEmpty(num) && !TextUtils.isEmpty(body)) {

            if (ContextCompat.checkSelfPermission(this@SMSActivity, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

                if (ActivityCompat.shouldShowRequestPermissionRationale(this@SMSActivity, Manifest.permission.SEND_SMS)){

                    ActivityCompat.requestPermissions(this@SMSActivity, arrayOf(Manifest.permission.SEND_SMS), 1)


                }else{

                    ActivityCompat.requestPermissions(this@SMSActivity, arrayOf(Manifest.permission.SEND_SMS), 1)
                }
            }else {

                var manager: SmsManager = SmsManager.getDefault()
                manager.sendTextMessage(num, null, body, null, null)

                Toast.makeText(getApplicationContext(), "SMS sent.",
                        Toast.LENGTH_LONG).show();
            }
        }
    }
}
