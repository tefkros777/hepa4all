package com.tefkros.myapplication

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.card.MaterialCardView

class DashboardActivity : AppCompatActivity() {
    private lateinit var mDrawer: DrawerLayout
    private lateinit var mToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        Log.d(LOG_TAG, "DashboardActivity loaded")

        title = "Dashboard"

        setSupportActionBar(findViewById(R.id.toolbar))
        mDrawer = findViewById(R.id.drawerLayout)
        mToggle = ActionBarDrawerToggle(this, mDrawer, R.string.open, R.string.close)
        mDrawer.addDrawerListener(mToggle)
        mToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawer.openDrawer(GravityCompat.START)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onBackPressed() {
        // If drawer is open just close it
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START)
        } else {
        // If drawer is closed show app exit dialog
            val builder = AlertDialog.Builder(this)
                .setTitle(R.string.app_name)
                .setMessage(R.string.exit_promt)
                .setCancelable(false)
                .setPositiveButton("Yes") { dialog, id -> finish() }
                .setNegativeButton("No") { dialog, id -> dialog.cancel() }
            builder.create().show()
        }
    }
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        mToggle.syncState()
    }
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        mToggle.onConfigurationChanged(newConfig)
    }

}