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
import com.example.app.viewSchedules.ViewSchedulesFragment

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

        val btnSchedule = view.findViewById<Button>(R.id.schedulesButton)
        if (!(activity as MainActivity).isLogged) {
            btnSchedule.setOnClickListener {
                (activity as MainActivity).replaceFragment(ViewSchedulesFragment())
            }
        } else {
            btnSchedule.setOnClickListener {
                (activity as MainActivity).replaceFragment(BuyTicketFragment())
            }
        }

        return view
    }
}