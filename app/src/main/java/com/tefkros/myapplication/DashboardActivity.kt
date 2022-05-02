package com.tefkros.myapplication

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.cardview.widget.CardView
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.card.MaterialCardView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.navigation.NavigationView

class DashboardActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var mAppbar: MaterialToolbar
    private lateinit var mDrawer: DrawerLayout
    private lateinit var mToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        Log.d(LOG_TAG, "DashboardActivity loaded")


        // DrawerLayout & App Bar
        mAppbar = findViewById(R.id.toolbar)
        setSupportActionBar(mAppbar)
        title = "Dashboard"
        mDrawer = findViewById(R.id.drawerLayout)
        mToggle = ActionBarDrawerToggle(this, mDrawer, R.string.open, R.string.close)
        mDrawer.addDrawerListener(mToggle)
        mToggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Add click listener to the Naviagation Menu
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)
        navigationView.setNavigationItemSelectedListener(this@DashboardActivity)

    }

    fun btnStakeholdersDir(cv: View) {
        Log.d(LOG_TAG,"Stakeholders Directory Clicked")
    }
    fun btnIndividualsDir(cv: View) {
        Log.d(LOG_TAG,"Individuals Directory Clicked")
    }
    fun btnOrganizationsDir(cv: View) {
        Log.d(LOG_TAG,"Organizations Directory Clicked")
    }
    fun btnHepaCourse(cv: View) {
        Log.d(LOG_TAG,"HEPA4ALL Course Clicked")
    }
    fun btnActivitiesDir(cv: View) {
        Log.d(LOG_TAG,"Activities Directory Clicked")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (mToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        // If drawer is open just close it
        if (mDrawer.isDrawerOpen(GravityCompat.START)) {
            mDrawer.closeDrawer(GravityCompat.START)
        } else {
        // If drawer is closed show app exit dialog
            val builder = MaterialAlertDialogBuilder(this)
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_item_open_in_browser -> {
                Log.d(LOG_TAG, "Navigation Drawer: Open in browser")
                val intent = Intent (Intent.ACTION_VIEW, Uri.parse(HEPA_WEBSITE))
                startActivity(intent)
            }
            R.id.nav_item_logout -> {
                Log.d(LOG_TAG, "Navigation Drawer: Logout")
                val builder = AlertDialog.Builder(this)
                    .setTitle(R.string.app_name)
                    .setMessage(R.string.exit_promt)
                    .setCancelable(false)
                    .setPositiveButton("Yes") { dialog, id ->
                        // Handle logout request
                        finish()
                        //TODO: Also need to handle firebase logout
                    }
                    .setNegativeButton("No") { dialog, id -> dialog.cancel() }
                builder.create().show()
            }
            R.id.nav_item_about -> {
                Log.d(LOG_TAG, "Navigation Drawer: About")
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        mDrawer.closeDrawer(GravityCompat.START)
        return true
    }


}