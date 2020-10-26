package com.shvants.balinatestapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.databinding.FragmentMainBinding
import com.shvants.balinatestapp.model.adapter.TabLayoutAdapter

class MainFragment : Fragment(R.layout.fragment_main) {

    private val binding: FragmentMainBinding by viewBinding()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabAdapter = TabLayoutAdapter(requireActivity().supportFragmentManager)
        tabAdapter.addFragments(
            listOf(
                Pair(LoginFragment(), "Login"),
                Pair(RegisterFragment(), "Register")
            )
        )

        binding.viewpager.adapter = tabAdapter
        binding.tabLayout.setupWithViewPager(binding.viewpager)
    }
}