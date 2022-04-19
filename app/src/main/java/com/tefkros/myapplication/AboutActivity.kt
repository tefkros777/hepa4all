package com.tefkros.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        Log.d(LOG_TAG, "AboutActivity loaded")

        title = "About This App"
        val body = getString(R.string.about_body)
        val credits = getString(R.string.credits)
        val version = getString(R.string.app_version) + "0.1"

    }
}