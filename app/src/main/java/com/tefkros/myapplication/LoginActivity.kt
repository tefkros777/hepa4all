package com.tefkros.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.google.android.material.button.MaterialButton

class LoginActivity : AppCompatActivity() {
    private lateinit var mProgressBar : ProgressBar
    private lateinit var mBtnLogin : MaterialButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        Log.d(LOG_TAG, "LoginActivity loaded")

        mProgressBar = findViewById(R.id.progressBar)
        mBtnLogin = findViewById(R.id.btnLogin)
    }

    override fun onResume() {
        super.onResume()

        // Initially the progressbar is invisible
        mProgressBar.visibility = View.INVISIBLE

        // Enable login button if it's disabled
       mBtnLogin.isEnabled = true

    }

    fun login(view: android.view.View) {
        Log.d(LOG_TAG, "Login button pressed")
        mProgressBar.visibility = View.VISIBLE

        // Disable login button while login is in process
        mBtnLogin.isEnabled = false
        // Implement firebase login

        // Skip formal login (for testing only)
        guestLogin()

    }

    fun signup(view: android.view.View) {
        Log.d(LOG_TAG, "Signup button pressed")
        // implement firebase signup
    }
    fun guestLogin() {
        Log.d(LOG_TAG, "Guest login button pressed")
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }
}