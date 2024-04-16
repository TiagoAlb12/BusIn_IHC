package com.example.app.wallet

import android.content.Context.MODE_PRIVATE
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.app.R

class WalletFragment : Fragment() {

    companion object {
        fun newInstance() = WalletFragment()
    }

    private val viewModel: WalletViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_wallet, container, false)
    }

    override fun onPause() {
        super.onPause()
        val walletBox = view?.findViewById<EditText>(R.id.walletBox)
        val walletValue = walletBox?.text.toString()
        val sharedPreferences = activity?.getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        if (walletValue.isNotEmpty()) {
            editor?.putString("walletValue", walletValue)
            editor?.apply()
        }
    }

    override fun onResume() {
        super.onResume()
        val walletBox = view?.findViewById<EditText>(R.id.walletBox)
        val sharedPreferences = activity?.getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val savedWalletValue = sharedPreferences?.getString("walletValue", "")
        if (!savedWalletValue.isNullOrEmpty()) {
            walletBox?.setText(savedWalletValue)
        }
    }
}