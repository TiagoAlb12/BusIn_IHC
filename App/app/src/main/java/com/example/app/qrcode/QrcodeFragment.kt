package com.example.app.qrcode

import android.content.Context.MODE_PRIVATE
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.app.MainActivity
import com.example.app.R
import com.example.app.wallet.WalletFragment

class QrcodeFragment : Fragment() {

    companion object {
        fun newInstance() = QrcodeFragment()
    }

    private val viewModel: QrcodeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_qrcode, container, false)

        val textView = view.findViewById<TextView>(R.id.add_funds_message_in_qr_code_page)
        textView.setOnClickListener {
            (activity as MainActivity).replaceFragment(WalletFragment(), R.id.wallet)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = activity?.getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val savedWalletValue = sharedPreferences?.getString("walletValue", "")
        if (!savedWalletValue.isNullOrEmpty()) {
            val textView = view.findViewById<TextView>(R.id.wallet_in_qrcode_page)
            textView.text = savedWalletValue
        }
    }

}