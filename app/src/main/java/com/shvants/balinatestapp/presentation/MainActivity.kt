package com.shvants.balinatestapp.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.presentation.fragment.MainFragment

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navMainController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.elevation = 0.0f

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_container) as NavHostFragment
        navMainController = navHostFragment.navController
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val mainFragment =
            supportFragmentManager.fragments[0].childFragmentManager.fragments[0] as MainFragment

        if (item?.itemId == android.R.id.home) mainFragment.openDrawer()

        return super.onOptionsItemSelected(item)
    }
}