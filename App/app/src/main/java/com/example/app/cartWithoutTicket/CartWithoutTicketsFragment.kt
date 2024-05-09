package com.example.app.cartWithoutTicket

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.app.MainActivity
import com.example.app.R
import com.example.app.buyTicket.BuyTicketFragment

class CartWithoutTicketsFragment : Fragment() {

    companion object {
        fun newInstance() = CartWithoutTicketsFragment()
    }

    private val viewModel: CartWithoutTicketsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_cart_without_tickets, container, false)

        val btnBack = view.findViewById<ImageView>(R.id.back_page_icon)
        btnBack.setOnClickListener {
            (activity as MainActivity).replaceFragment(BuyTicketFragment())
        }

        return view
    }
}