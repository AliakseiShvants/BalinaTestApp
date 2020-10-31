package com.shvants.balinatestapp.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.contract.MainContract
import com.shvants.balinatestapp.databinding.FragmentMainBinding
import com.shvants.balinatestapp.databinding.FragmentTabLayoutBinding
import com.shvants.balinatestapp.presenter.MainPresenter
import java.util.concurrent.atomic.AtomicInteger

class MainFragment : Fragment(R.layout.fragment_main), MainContract.View {

    private val binding: FragmentMainBinding by viewBinding()

    private val page = AtomicInteger(0)
    private val presenter = MainPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        presenter.loadImage(page.incrementAndGet())
        with(binding.recyclerview) {
            layoutManager = GridLayoutManager(requireContext(), 3, RecyclerView.HORIZONTAL, false)
        }
    }
}