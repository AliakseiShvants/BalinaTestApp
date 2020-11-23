package com.shvants.balinatestapp.presentation.fragment

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.core.view.GravityCompat
import androidx.core.view.forEach
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.navigation.NavigationView
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.databinding.FragmentMainBinding
import com.shvants.balinatestapp.domain.mvp.contract.MainContract
import com.shvants.balinatestapp.presentation.MainActivity
import org.koin.core.KoinComponent
import org.koin.core.inject

class MainFragment : Fragment(R.layout.fragment_main),
    MainContract.View,
    NavigationView.OnNavigationItemSelectedListener,
    KoinComponent {

    private val presenter: MainContract.Presenter by inject()
    private val binding: FragmentMainBinding by viewBinding()

    private lateinit var activity: MainActivity

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity = requireActivity() as MainActivity

        with(activity) {
            supportActionBar?.let {
                it.setDisplayHomeAsUpEnabled(true)
                it.setHomeAsUpIndicator(R.drawable.ic_menu)
            }
        }

        presenter.attachView(this)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .add(R.id.nav_fragment_container, PhotosFragment.INSTANCE)
            .commit()

        with(binding) {
            navigation.setNavigationItemSelectedListener(this@MainFragment)
            navigation.menu.getItem(0).isChecked = true
            arguments?.getString("username")?.let {
                (navigation.getHeaderView(0) as TextView).text = it
            }
        }
    }

    override fun replaceFragment(fragment: Fragment) {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun setCheckedItem(item: MenuItem) {
        binding.navigation.menu.forEach {
            it.isChecked = it.itemId == item.itemId
        }
    }

    override fun onDestroyView() {
        presenter.detachView()

        super.onDestroyView()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        presenter.navigationItemSelected(item, binding.drawerLayout)

        return true
    }

    fun openDrawer() {
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }
}