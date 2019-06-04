package com.example.sharedpreferencessample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var prefs: MyPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        prefs = MyPreferences.getInstance(context = this)

        btnSave.setOnClickListener {
            prefs.saveUserName(etUserName.text.toString())
            prefs.savePhoneNumber(etPhoneNumber.text.toString())
        }

        btnClear.setOnClickListener {
            etUserName.text.clear()
            etPhoneNumber.text.clear()
        }

        btnRetrieve.setOnClickListener {
            etUserName.setText(prefs.getUserName())
            etPhoneNumber.setText(prefs.getPhoneNumber())
        }
    }
}
