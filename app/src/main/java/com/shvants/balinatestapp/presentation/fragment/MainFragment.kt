package com.shvants.balinatestapp.presentation.fragment

import android.os.Bundle
import android.view.MenuItem
import android.view.View
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
        presenter.attachView(this)
        requireActivity().supportFragmentManager
            .beginTransaction()
            .add(R.id.nav_fragment_container, PhotosFragment.INSTANCE)
            .commit()
        binding.navigation.setNavigationItemSelectedListener(this)
        binding.navigation.menu.getItem(0).isChecked = true
    }

    override fun replaceFragment(fragment: Fragment) {
        activity.supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_fragment_container, fragment)
            .commit()
    }

    override fun setCheckedItem(item: MenuItem) {
        binding.navigation.setCheckedItem(item)
    }

    override fun onDestroyView() {
        presenter.detachView()

        super.onDestroyView()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        presenter.navigationItemSelected(item, binding.drawerLayout)

        return true
    }
}