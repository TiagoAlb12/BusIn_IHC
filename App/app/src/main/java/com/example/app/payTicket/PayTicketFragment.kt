package com.example.app.payTicket

import android.content.Context
import android.content.Context.MODE_PRIVATE
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.app.MainActivity
import com.example.app.R
import com.example.app.home.HomeFragment
import com.example.app.homelogin.HomeLoginFragment
import com.example.app.registration.RegistrationFragment
import com.example.app.ticketWithTickets.TicketWithTicketsFragment

class PayTicketFragment : Fragment() {

    companion object {
        fun newInstance() = PayTicketFragment()
    }

    private val viewModel: PayTicketViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_pay_ticket, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = activity?.getSharedPreferences("MySharedPref", Context.MODE_PRIVATE)
        val savedWalletValue = sharedPreferences?.getString("walletValue", "")
        if (!savedWalletValue.isNullOrEmpty()) {
            val textView = view.findViewById<TextView>(R.id.value_wallet_in_pay_ticket_page)
            textView.text = savedWalletValue
        }

        val button = view.findViewById<Button>(R.id.pay_button)
        button.setOnClickListener { retirarDinheiro(it) }
    }

    fun retirarDinheiro(view: View) {
        val walletBox = getView()?.findViewById<TextView>(R.id.value_wallet_in_pay_ticket_page)
        val walletValue = walletBox?.text.toString().replace("€", "").replace(",", ".").toDoubleOrNull()
        val ticketbox = getView()?.findViewById<TextView>(R.id.total_price_in_pay_ticket_page)
        val ticketValue = ticketbox?.text.toString().replace("€", "").replace(",", ".").toDoubleOrNull()

        if (walletValue != null && walletValue >= ticketValue!!) {
            val newWalletValue = walletValue - ticketValue
            val newWalletValueStr = String.format("%.2f€", newWalletValue)
            walletBox?.setText(newWalletValueStr)

            val sharedPreferences = activity?.getSharedPreferences("MySharedPref", MODE_PRIVATE)
            val editor = sharedPreferences?.edit()
            editor?.putString("walletValue", newWalletValueStr)
            editor?.apply()

            (activity as MainActivity).buyedTicket = true
            (activity as MainActivity).setupLoginBinding()
            (activity as MainActivity).replaceFragment(TicketWithTicketsFragment(), R.id.ticket)

        } else {
            Toast.makeText(context, "Insuficient funds in your wallet!", Toast.LENGTH_SHORT).show()
        }
    }

}