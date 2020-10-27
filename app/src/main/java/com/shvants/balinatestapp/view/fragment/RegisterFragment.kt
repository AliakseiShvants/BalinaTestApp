package com.shvants.balinatestapp.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.contract.RegisterContract
import com.shvants.balinatestapp.databinding.FragmentRegisterBinding
import com.shvants.balinatestapp.util.Constant.Error.CONFIRM_PASSWORD_ERROR
import com.shvants.balinatestapp.util.Constant.Error.PASSWORD_ERROR
import com.shvants.balinatestapp.util.Constant.Error.USERNAME_ERROR
import org.koin.android.ext.android.inject

class RegisterFragment : Fragment(R.layout.fragment_register), RegisterContract.View {

    private val binding: FragmentRegisterBinding by viewBinding()

    private val presenter: RegisterContract.Presenter by inject()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.bindView()
    }

    override fun register() {
        TODO("Not yet implemented")
    }

    override fun setError(
        isUsernameValid: Boolean,
        isPasswordValid: Boolean,
        isConfirmPasswordValid: Boolean
    ) {
        if (!isUsernameValid) binding.registerUsernameInput.error = USERNAME_ERROR
        if (!isPasswordValid) binding.registerPassword.error = PASSWORD_ERROR
        if (!isConfirmPasswordValid) binding.registerConfirmPasswordInput.error =
            CONFIRM_PASSWORD_ERROR
    }

    private fun FragmentRegisterBinding.bindView() {
        registerButton.setOnClickListener {
//            clearError()
            presenter.validate(
                username = registerUsername.text.toString(),
                password = registerPassword.text.toString(),
                confirmPassword = registerConfirmPassword.text.toString()
            )
        }
    }

    private fun FragmentRegisterBinding.clearError() {
        registerUsernameInput.error = ""
        registerConfirmPasswordInput.error = ""
        registerConfirmPasswordInput.error = ""
    }
}