package com.swayam.kotlintestapp.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.swayam.kotlintestapp.R
import java.util.*

class TextToSpeachActivity : AppCompatActivity() {

    var textToSpeach : TextToSpeech? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_to_speach)

        textToSpeach = TextToSpeech(this@TextToSpeachActivity, TextToSpeech.OnInitListener { status ->

            run {

            if (status != TextToSpeech.ERROR)
                textToSpeach!!.language = Locale.UK
        } })

    }

    fun speak(view : View){

        var etTextToSpeach = findViewById(R.id.etTextToSpeach) as EditText
        var text = etTextToSpeach.text.toString().trim()

        if (!TextUtils.isEmpty(text)) {
            textToSpeach!!.speak(text, TextToSpeech.QUEUE_FLUSH, null)
            Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        textToSpeach!!.stop()
        textToSpeach!!.shutdown()
    }
}
