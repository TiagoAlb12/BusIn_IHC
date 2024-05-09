package com.example.app.ticketWithTickets

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.app.MainActivity
import com.example.app.R
import com.example.app.ticketInfos.TicketInfosFragment

class TicketWithTicketsFragment : Fragment() {

    companion object {
        fun newInstance() = TicketWithTicketsFragment()
    }

    private val viewModel: TicketWithTicketsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_ticket_with_tickets, container, false)

        val TicketInfo = view.findViewById<View>(R.id.rectangle_1)
        TicketInfo.setOnClickListener {
            (activity as MainActivity).replaceFragment(TicketInfosFragment())
        }

        return view
    }
}