package com.shvants.balinatestapp.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.contract.TabLayoutContract
import com.shvants.balinatestapp.databinding.FragmentRegisterBinding
import com.shvants.balinatestapp.presenter.RegisterPresenter

class RegisterFragment : Fragment(R.layout.fragment_register), TabLayoutContract.View {

    private val binding: FragmentRegisterBinding by viewBinding()
    private val presenter = RegisterPresenter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        binding.bindView()
    }

    override fun onDestroyView() {
        presenter.detachView()

        super.onDestroyView()
    }

    override fun setError(
        usernameError: String?,
        passwordError: String?,
        confirmPasswordError: String?
    ) {
        with(binding) {
            usernameError?.let { registerUsernameInput.error = it }
            passwordError?.let { registerPasswordInput.error = it }
            confirmPasswordError?.let { registerConfirmPasswordInput.error = it }
        }
    }

    override fun navigate() {
        findNavController().navigate(R.id.action_tabLayoutFragment_to_mainFragment)
    }

    private fun FragmentRegisterBinding.bindView() {
        registerButton.setOnClickListener {
            val username = registerUsername.text.toString()
            val password = registerPassword.text.toString()
            val isValid = presenter.validate(
                username = username,
                password = password,
                confirmPassword = registerConfirmPassword.text.toString()
            )

            if (isValid) presenter.execute(username, password)
        }
    }
}