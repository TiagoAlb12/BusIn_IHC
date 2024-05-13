package com.example.app.buyTicket

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.example.app.MainActivity
import com.example.app.R

class BuyTicketFragment : Fragment() {
    companion object {
        fun newInstance() = BuyTicketFragment()
    }

    private val viewModel: BuyTicketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_buy_ticket, container, false)

        val ticketIds = arrayOf(
            R.id.first_ticket, R.id.second_ticket, R.id.third_ticket, R.id.fourth_ticket,
            R.id.fifth_ticket, R.id.sixth_ticket, R.id.seventh_ticket, R.id.eighth_ticket,
            R.id.ninth_ticket, R.id.tenth_ticket, R.id.eleventh_ticket, R.id.twelfth_ticket,
            R.id.thirteenth_ticket, R.id.fourteenth_ticket
        )

        val mainActivity = activity as MainActivity

        ticketIds.forEach { ticketId ->
            view.findViewById<ImageView>(ticketId).setOnClickListener {
                if (!mainActivity.isButtonClicked) {
                    mainActivity.incrementCartItemCount()
                    ticketIds.forEach { id ->
                        view.findViewById<ImageView>(id).isClickable = false
                    }
                    mainActivity.isButtonClicked = true
                    Toast.makeText(context, "The ticket was added to your cart!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }
}