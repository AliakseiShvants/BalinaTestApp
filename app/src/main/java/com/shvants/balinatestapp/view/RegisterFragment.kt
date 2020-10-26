package com.shvants.balinatestapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.databinding.FragmentRegisterBinding
import com.shvants.balinatestapp.presenter.RegisterContract

class RegisterFragment : Fragment(R.layout.fragment_register), RegisterContract.View {

    private val binding: FragmentRegisterBinding by viewBinding()

    private var presenter: RegisterContract.Presenter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.registerButton.setOnClickListener {
            binding.registerUsernameInput.error = "Error"
        }
    }
}