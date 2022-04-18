package com.tefkros.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(LOG_TAG, "LoginActivity loaded")
    }

    fun login(view: android.view.View) {
        Log.d(LOG_TAG, "Login button pressed")
        // Implement firebase login
    }

    fun signup(view: android.view.View) {
        Log.d(LOG_TAG, "Signup button pressed")
        // implement firebase signup
    }
    fun guestLogin(view: android.view.View) {
        Log.d(LOG_TAG, "Guest login button pressed")
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }
}