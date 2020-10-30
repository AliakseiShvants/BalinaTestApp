package com.shvants.balinatestapp.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.contract.RegisterContract
import com.shvants.balinatestapp.databinding.FragmentRegisterBinding
import org.koin.core.KoinComponent
import org.koin.core.inject

class RegisterFragment : Fragment(R.layout.fragment_register), RegisterContract.View,
    KoinComponent {

    private val binding: FragmentRegisterBinding by viewBinding()

    private val presenter: RegisterContract.Presenter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.attachView(this)
        binding.bindView()
    }

    override fun onDestroyView() {
        presenter.detachView()

        super.onDestroyView()
    }

    override fun register() {
        TODO("Not yet implemented")
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

    override fun navigate(resId: Int) {
        findNavController().navigate(resId)
    }

    private fun FragmentRegisterBinding.bindView() {
        registerButton.setOnClickListener {
            presenter.validate(
                username = registerUsername.text.toString(),
                password = registerPassword.text.toString(),
                confirmPassword = registerConfirmPassword.text.toString()
            )
        }
    }
}