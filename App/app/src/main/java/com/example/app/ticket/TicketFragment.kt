package com.example.app.ticket

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.app.MainActivity
import com.example.app.R
import com.example.app.homelogin.HomeLoginFragment

class TicketFragment : Fragment() {

    companion object {
        fun newInstance() = TicketFragment()
    }

    private val viewModel: TicketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_ticket_without_tickets, container, false)

        val ticketButton = view.findViewById<Button>(R.id.buy_ticket_button)
        ticketButton.setOnClickListener {
            (activity as MainActivity).replaceFragment(HomeLoginFragment())
        }

        return view
    }
}