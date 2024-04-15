package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.app.databinding.ActivityMainBinding
import com.example.app.home.HomeFragment
import com.example.app.map.MapFragment
import com.example.app.qrcode.QrcodeFragment
import com.example.app.ticket.TicketFragment
import com.example.app.wallet.WalletFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragment(HomeFragment())
                R.id.ticket -> replaceFragment(TicketFragment())
                R.id.map -> replaceFragment(MapFragment())
                R.id.qrcode -> replaceFragment(QrcodeFragment())
                R.id.wallet -> replaceFragment(WalletFragment())

                else ->{



                }

            }

            true

        }

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = ""
        setSupportActionBar(toolbar)


    }

    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()


    }
}