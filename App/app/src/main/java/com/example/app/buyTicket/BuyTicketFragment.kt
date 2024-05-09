package com.example.app.buyTicket

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.app.MainActivity
import com.example.app.R

class BuyTicketFragment : Fragment() {

    private var isButtonClicked = false

    companion object {
        fun newInstance() = BuyTicketFragment()
    }

    private val viewModel: BuyTicketViewModel by viewModels()

    fun onTicketButtonClick(view: View) {
        // Aumenta o contador em 1
        val mainActivity = activity as MainActivity
        mainActivity.incrementCartItemCount()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_buy_ticket, container, false)

        val firstTicket = view.findViewById<ImageView>(R.id.first_ticket)
        firstTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        return view
    }
}