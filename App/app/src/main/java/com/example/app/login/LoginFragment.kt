package com.example.app.login

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.R
import android.widget.Button
import android.widget.TextView
import com.example.app.MainActivity
import com.example.app.changepassword.ChangePasswordFragment
import com.example.app.registration.RegistrationFragment


class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val loginButton = view.findViewById<Button>(R.id.login_button_in_login_page)
        loginButton.setOnClickListener {
            (activity as MainActivity).isLogged = true
            (activity as MainActivity).setupLoginBinding()
        }

        val registerButton = view.findViewById<Button>(R.id.register_button_in_login_page)
        registerButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(RegistrationFragment())
        }

        val forgotPasswordText =
            view.findViewById<TextView>(R.id.forgot_password_text_in_login_page)
        forgotPasswordText.setOnClickListener {
            (activity as MainActivity).replaceFragment(ChangePasswordFragment())
        }
        return view
    }
}