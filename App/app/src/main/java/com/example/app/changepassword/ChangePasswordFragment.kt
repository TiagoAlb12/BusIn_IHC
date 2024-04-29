package com.example.app.changepassword

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.R
import android.widget.Button
import com.example.app.MainActivity
import com.example.app.login.LoginFragment

class ChangePasswordFragment : Fragment() {

    companion object {
        fun newInstance() = ChangePasswordFragment()
    }

    private val viewModel: ChangePasswordViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_change_password, container, false)

        val sendEmailButton = view.findViewById<Button>(R.id.send_button_in_changePassword_page)
        sendEmailButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(LoginFragment())
        }

        return view
    }
}