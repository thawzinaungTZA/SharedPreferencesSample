package com.example.sharedpreferencessample

import android.content.Context

class MyPreferences(context: Context) {

    private val sharedPref = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    companion object {
        const val PREFERENCES_NAME = "my_preferences"
        const val PREFS_USERNAME = "username"
        const val PREFS_PHONE_NUMBER = "phone_number"

        private var instance: MyPreferences? = null

        fun getInstance(context: Context): MyPreferences {
            if (instance == null) {
                instance = MyPreferences(context)
            }
            return instance as MyPreferences
        }
    }

    fun saveUserName(userName: String) {
        with(sharedPref.edit()) {
            putString(PREFS_USERNAME, userName)
            apply()
        }
    }

    fun getUserName(): String? = sharedPref.getString(PREFS_USERNAME, null)

    fun savePhoneNumber(phoneNumber: String) {
        with(sharedPref.edit()) {
            putString(PREFS_PHONE_NUMBER, phoneNumber)
            apply()
        }
    }

    fun getPhoneNumber(): String? = sharedPref.getString(PREFS_PHONE_NUMBER, null)

}