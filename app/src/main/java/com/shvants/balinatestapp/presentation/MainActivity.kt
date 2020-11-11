package com.shvants.balinatestapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.shvants.balinatestapp.R

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var navMainController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.elevation = 0.0f

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_container) as NavHostFragment
        navMainController = navHostFragment.navController
    }
}