package com.example.app.cartWithTicket

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import com.example.app.MainActivity
import com.example.app.R
import com.example.app.buyTicket.BuyTicketFragment
import com.example.app.payTicket.PayTicketFragment

class CartWithTicketFragment : Fragment() {

    companion object {
        fun newInstance() = CartWithTicketFragment()
    }

    private val viewModel: CartWithTicketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_cart_with_ticket, container, false)

        val btnBack = view.findViewById<ImageView>(R.id.back_page_icon)
        btnBack.setOnClickListener {
            (activity as MainActivity).replaceFragment(BuyTicketFragment())
        }

        val btnPay = view.findViewById<Button>(R.id.schedulesButton)
        btnPay.setOnClickListener {
            (activity as MainActivity).replaceFragment(PayTicketFragment())
        }

        return view
    }
}