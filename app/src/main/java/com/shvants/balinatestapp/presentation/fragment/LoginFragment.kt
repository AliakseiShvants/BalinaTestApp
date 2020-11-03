package com.shvants.balinatestapp.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.shvants.balinatestapp.R
import com.shvants.balinatestapp.databinding.FragmentLoginBinding
import com.shvants.balinatestapp.domain.mvp.contract.LoginContract
import org.koin.android.ext.android.inject
import org.koin.core.KoinComponent

class LoginFragment : Fragment(R.layout.fragment_login), LoginContract.View, KoinComponent {

    private val binding: FragmentLoginBinding by viewBinding()
    private val presenter: LoginContract.Presenter by inject()

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

    override fun navigate() {
        findNavController().navigate(R.id.action_tabLayoutFragment_to_mainFragment)
    }

    private fun FragmentLoginBinding.bindView() {
        loginButton.setOnClickListener {
            val username = /*loginUsername.text.toString()*/"ashvants91"
            val password = /*loginPassword.text.toString()*/"ashvants91"
            val isValid = presenter.validate(
                username = username,
                password = password,
            )

            if (isValid) presenter.execute(username, password)
        }
    }
}