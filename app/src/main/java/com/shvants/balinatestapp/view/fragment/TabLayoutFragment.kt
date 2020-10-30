package com.shvants.balinatestapp.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.databinding.FragmentTabLayoutBinding
import com.shvants.balinatestapp.model.adapter.TabLayoutAdapter

class TabLayoutFragment : Fragment(R.layout.fragment_tab_layout) {

    private val binding: FragmentTabLayoutBinding by viewBinding()

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