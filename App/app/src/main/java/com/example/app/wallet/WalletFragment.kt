package com.example.app.wallet

import android.content.Context.MODE_PRIVATE
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.app.R

class WalletFragment : Fragment() {

    companion object {
        fun newInstance() = WalletFragment()
    }

    private val viewModel: WalletViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    private var openAccordionContentView: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_wallet, container, false)
        val accordionLayout = view.findViewById<LinearLayout>(R.id.accordion)
        val titles = arrayOf("MB Way", "Multibanco")
        val contentLayouts = arrayOf(
            R.layout.mb_way_content_view,
            R.layout.multibanco_content_view
        )
        val yourIconArray = arrayOf(
            R.drawable.mbway_logo,
            R.drawable.multibanco_logo
        )

        for (i in titles.indices) {
            // extende o layout accordion com o layout title_view, e define o texto do title_view
            val titleViewLayout = inflater.inflate(R.layout.title_view, accordionLayout, false) as LinearLayout
            val titleView = titleViewLayout.findViewById<TextView>(R.id.title_text)
            val titleIcon = titleViewLayout.findViewById<ImageView>(R.id.title_icon)
            titleView.id = View.generateViewId()
            titleView.text = titles[i]
            titleIcon.setImageResource(yourIconArray[i])
            accordionLayout.addView(titleViewLayout)

            // extende o layout accordion com o layout content_view
            val accordionContentView = inflater.inflate(contentLayouts[i], accordionLayout, false)
            accordionContentView.id = View.generateViewId()
            accordionContentView.visibility = View.GONE
            accordionLayout.addView(accordionContentView)

            // adiciona um listener ao titleView para abrir e fechar o accordion
            titleView.setOnClickListener {
                //fecha o accordion se estiver aberto
                if (openAccordionContentView != null && openAccordionContentView != accordionContentView) {
                    openAccordionContentView?.visibility = View.GONE
                }
                accordionContentView.visibility = if (accordionContentView.visibility == View.VISIBLE) View.GONE else View.VISIBLE
                openAccordionContentView = if (accordionContentView.visibility == View.VISIBLE) accordionContentView else null
            }
        }

        return view
    }


    override fun onPause() {
        super.onPause()
        val walletBox = view?.findViewById<TextView>(R.id.walletBox)
        val walletValue = walletBox?.text.toString()
        val sharedPreferences = activity?.getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        if (walletValue.isNotEmpty()) {
            editor?.putString("walletValue", walletValue)
            editor?.apply()
        }
    }

    override fun onResume() {
        super.onResume()
        val walletBox = view?.findViewById<TextView>(R.id.walletBox)
        val sharedPreferences = activity?.getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val savedWalletValue = sharedPreferences?.getString("walletValue", "")
        if (!savedWalletValue.isNullOrEmpty()) {
            walletBox?.setText(savedWalletValue)
        }
    }
}