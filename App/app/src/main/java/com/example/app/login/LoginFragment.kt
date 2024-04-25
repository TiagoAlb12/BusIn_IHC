package com.example.app.login

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.R
import android.widget.Button
import com.example.app.home.HomeFragment
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
        val primeiroBotao = view.findViewById<Button>(R.id.login_button_in_login_page)
        val segundoBotao = view.findViewById<Button>(R.id.register_button_in_login_page)

        val onClickListener = View.OnClickListener { view ->
            when (view.id) {
                R.id.login_button_in_login_page -> {
                    // Código para navegar para o Fragmento1
                    val fragment1 = HomeFragment()
                    replaceFragment(fragment1)
                }
                R.id.register_button_in_login_page -> {
                    // Código para navegar para o Fragmento2
                    val fragment2 = RegistrationFragment()
                    replaceFragment(fragment2)
                }
            }
        }

        // Define o OnClickListener para ambos os botões
        primeiroBotao.setOnClickListener(onClickListener)
        segundoBotao.setOnClickListener(onClickListener)

        return view
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.fragment_container, fragment)
        fragmentTransaction?.addToBackStack(null)
        fragmentTransaction?.commit()
    }
}