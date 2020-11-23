package com.shvants.balinatestapp.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.databinding.FragmentLoginBinding
import com.shvants.balinatestapp.domain.mvp.contract.LoginContract
import org.koin.android.ext.android.inject
import org.koin.core.KoinComponent

class LoginFragment : Fragment(R.layout.fragment_login), LoginContract.View, KoinComponent {

    private val presenter: LoginContract.Presenter by inject()
    private val binding: FragmentLoginBinding by viewBinding()

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
            usernameError?.let { loginUsernameInput.error = it }
            passwordError?.let { loginPasswordInput.error = it }
        }
    }

    override fun navigate(username: String) {
        findNavController().navigate(
            R.id.action_tabLayoutFragment_to_mainFragment,
            bundleOf("username" to username)
        )
    }

    private fun FragmentLoginBinding.bindView() {
        loginButton.setOnClickListener {
            val username = loginUsername.text.toString()
            val password = loginPassword.text.toString()
            val isValid = presenter.validate(
                username = username,
                password = password,
            )

            if (isValid) presenter.execute(username, password)
        }
    }
}