package com.swayam.kotlintestapp.ui.activity

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

import com.swayam.kotlintestapp.R

class ContactPreferencesActivity : AppCompatActivity() {

    val PREFERENCE_NAME = "Contact_preference"
    val USER_NAME = "rajesh"
    val PASSWORD = "12345"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact_preferences)

        val sp : SharedPreferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        var sEditor = sp.edit()
        sEditor.putString(USER_NAME, USER_NAME)
        sEditor.putString(PASSWORD, PASSWORD)
        sEditor.commit()
    }

    fun logIn(view : View){

        val etUserName = findViewById(R.id.etUserName) as EditText
        val etPassword = findViewById(R.id.etPassword) as EditText

        val userName = etUserName.text.toString().trim()
        val passowrd = etPassword.text.toString().trim()

        val sp : SharedPreferences = getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)
        val name = sp.getString(USER_NAME, "")
        val pass = sp.getString(PASSWORD, "")

        if (userName.contentEquals(name) && passowrd.contentEquals(pass)) {

            Toast.makeText(this@ContactPreferencesActivity, "LoggedIn Successful", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(this@ContactPreferencesActivity, "Invalid UserName/Password", Toast.LENGTH_SHORT).show()

        }

    }
}
