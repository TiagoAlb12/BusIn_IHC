package com.example.app.login

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.R
import androidx.fragment.app.FragmentTransaction
import com.example.app.home.HomeFragment


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
    ): View {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    fun onLoginSuccess() {
        // Inicia a transação de fragmento para substituir o fragmento atual pelo fragmento inicial (home fragment)
        val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()
        transaction.replace(R.id.fragment_container, HomeFragment()) // Substitui pelo seu nome de fragmento home
        transaction.addToBackStack(null) // Permite voltar à página de login pressionando o botão de voltar
        transaction.commit()
    }
}