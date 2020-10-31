package com.shvants.balinatestapp.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.databinding.FragmentTabLayoutBinding
import com.shvants.balinatestapp.model.adapter.TabLayoutAdapter
import com.shvants.network.api.ITokenHelper
import org.koin.core.KoinComponent
import org.koin.core.inject

class TabLayoutFragment : Fragment(R.layout.fragment_tab_layout), KoinComponent {

    private val binding: FragmentTabLayoutBinding by viewBinding()
    private val tokenHelper: ITokenHelper by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabAdapter = TabLayoutAdapter(requireActivity().supportFragmentManager)
        tabAdapter.addFragments(
            listOf(
                Pair(LoginFragment(), "Login"),
                Pair(RegisterFragment(), "Register")
            )
        )

        with(binding) {
            viewpager.adapter = tabAdapter
            viewpager.currentItem = if (tokenHelper.token == null) 1 else 0
            tabLayout.setupWithViewPager(binding.viewpager)
        }
    }

    override fun onDestroyView() {

        super.onDestroyView()
    }
}