package com.tefkros.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.material.card.MaterialCardView

class DashboardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        Log.d(LOG_TAG, "DashboardActivity loaded")

        title = "Dashboard"

    }

    fun btnStakeholdersDir(view: android.view.View) {
        Log.d(LOG_TAG,"Stakeholders Directory Clicked")
    }
    fun btnIndividualsDir(view: android.view.View) {
        Log.d(LOG_TAG,"Individuals Directory Clicked")
    }
    fun btnOrganizationsDir(view: android.view.View) {
        Log.d(LOG_TAG,"Organizations Directory Clicked")
    }
    fun btnHepaCourse(view: android.view.View) {
        Log.d(LOG_TAG,"HEPA4ALL Course Clicked")
    }
    fun btnActivitiesDir(view: android.view.View) {
        Log.d(LOG_TAG,"Activities Directory Clicked")
    }


}