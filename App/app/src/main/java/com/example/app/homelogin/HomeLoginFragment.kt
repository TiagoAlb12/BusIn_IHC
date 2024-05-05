package com.example.app.homelogin

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.app.MainActivity
import com.example.app.R
import com.example.app.buyTicket.BuyTicketFragment

class HomeLoginFragment : Fragment() {

    companion object {
        fun newInstance() = HomeLoginFragment()
    }

    private val viewModel: HomeLoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_home_login, container, false)

        val btnBuy = view.findViewById<Button>(R.id.buyButton)
        btnBuy.setOnClickListener {
            (activity as MainActivity).setupShopBinding()
        }

        return view
    }
}