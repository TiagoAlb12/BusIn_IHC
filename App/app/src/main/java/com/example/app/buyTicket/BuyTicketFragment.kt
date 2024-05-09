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
        val secondTicket = view.findViewById<ImageView>(R.id.second_ticket)
        val thirdTicket = view.findViewById<ImageView>(R.id.third_ticket)
        val fourthTicket = view.findViewById<ImageView>(R.id.fourth_ticket)
        val fifthTicket = view.findViewById<ImageView>(R.id.fifth_ticket)
        val sixthTicket = view.findViewById<ImageView>(R.id.sixth_ticket)
        val seventhTicket = view.findViewById<ImageView>(R.id.seventh_ticket)
        val eighthTicket = view.findViewById<ImageView>(R.id.eighth_ticket)
        val ninthTicket = view.findViewById<ImageView>(R.id.ninth_ticket)
        val tenthTicket = view.findViewById<ImageView>(R.id.tenth_ticket)
        val eleventhTicket = view.findViewById<ImageView>(R.id.eleventh_ticket)
        val twelfthTicket = view.findViewById<ImageView>(R.id.twelfth_ticket)
        val thirteenthTicket = view.findViewById<ImageView>(R.id.thirteenth_ticket)
        val fourteenthTicket = view.findViewById<ImageView>(R.id.fourteenth_ticket)

        firstTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        secondTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        thirdTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        fourthTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        fifthTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        sixthTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        seventhTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        eighthTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        ninthTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        tenthTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        eleventhTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        twelfthTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        thirteenthTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        fourteenthTicket.setOnClickListener {
            if (!isButtonClicked) {
                // Aumenta o contador em 1
                val mainActivity = activity as MainActivity
                mainActivity.incrementCartItemCount()
                // Desativa o clique no botão
                firstTicket.isClickable = false
                secondTicket.isClickable = false
                thirdTicket.isClickable = false
                fourthTicket.isClickable = false
                fifthTicket.isClickable = false
                sixthTicket.isClickable = false
                seventhTicket.isClickable = false
                eighthTicket.isClickable = false
                ninthTicket.isClickable = false
                tenthTicket.isClickable = false
                eleventhTicket.isClickable = false
                twelfthTicket.isClickable = false
                thirteenthTicket.isClickable = false
                fourteenthTicket.isClickable = false
                // Define o estado do botão como clicado
                isButtonClicked = true
            }
        }

        return view
    }
}