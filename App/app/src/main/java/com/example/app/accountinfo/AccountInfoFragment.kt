package com.example.app.accountinfo

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.R
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.app.MainActivity
import com.example.app.homelogin.HomeLoginFragment

class AccountInfoFragment : Fragment() {

    private var selecionadoMasculino = true
    private var selecionadoFeminino = false

    companion object {
        fun newInstance() = AccountInfoFragment()
    }

    private val viewModel: AccountInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_account_info, container, false)

        val botaoMasculino = view.findViewById<Button>(R.id.male_button)
        botaoMasculino.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.my_primary))
        val botaoFeminino = view.findViewById<Button>(R.id.female_button)

        botaoMasculino.setOnClickListener {
            if (!selecionadoMasculino) {
                botaoMasculino.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.my_primary))
                selecionadoMasculino = true
                botaoFeminino.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
                selecionadoFeminino = false
            }
        }

        botaoFeminino.setOnClickListener {
            if (!selecionadoFeminino) {
                botaoFeminino.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.my_primary))
                selecionadoFeminino = true
                botaoMasculino.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
                selecionadoMasculino = false
            }
        }

        val confirmButton = view.findViewById<Button>(R.id.confirm_button_in_account_info_page)
        confirmButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(HomeLoginFragment())
        }

        val loginText = view.findViewById<TextView>(R.id.logout_text_in_account_info_page)
        loginText.setOnClickListener {
            (activity as MainActivity).isLogged = false
            (activity as MainActivity).setupNotLoginBinding()
        }

        return view
    }
}