package com.shvants.balinatestapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabAdapter = MyFPAdapter(supportFragmentManager)
        tabAdapter.addFragments(
            listOf(
                Pair(LoginFragment(), "Login"),
                Pair(LoginFragment(), "Register")
            )
        )

        val viewPager = findViewById<ViewPager>(R.id.login_viewpager)
        viewPager.adapter = tabAdapter

        val tabLayout = findViewById<TabLayout>(R.id.login_tab_layout)
        tabLayout.setupWithViewPager(viewPager)
    }
}