package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.app.databinding.ActivityMainWithoutLoginBinding
import com.example.app.home.HomeFragment
import com.example.app.map.MapFragment
import com.example.app.qrcode.QrcodeFragment
import com.example.app.ticket.TicketFragment
import com.example.app.wallet.WalletFragment
import android.app.DatePickerDialog
import android.widget.DatePicker
import android.view.View
import java.util.*
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import android.widget.ImageButton
import android.widget.TextView
import com.example.app.accountinfo.AccountInfoFragment
import com.example.app.databinding.ActivityMainWithLoginBinding
import com.example.app.login.LoginFragment
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.replace
import com.example.app.buyTicket.BuyTicketFragment
import com.example.app.databinding.ActivityMainInfoPageBinding
import com.example.app.databinding.ActivityMainWithCartBinding
import com.example.app.homelogin.HomeLoginFragment


class MainActivity : AppCompatActivity() {

    private lateinit var notLoginBinding: ActivityMainWithoutLoginBinding
    private lateinit var loginBinding: ActivityMainWithLoginBinding
    private lateinit var shopBinding: ActivityMainWithCartBinding
    private lateinit var infoBinding: ActivityMainInfoPageBinding
    private lateinit var toolbar: Toolbar
    var isLogged: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupNotLoginBinding()
    }

    fun setupNotLoginBinding() {
        notLoginBinding = ActivityMainWithoutLoginBinding.inflate(layoutInflater)
        setContentView(notLoginBinding.root)
        replaceFragment(HomeFragment())

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = ""
        setSupportActionBar(toolbar)

        notLoginBinding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeFragment())
                R.id.ticket -> replaceFragment(LoginFragment())
                R.id.map -> replaceFragment(LoginFragment())
                R.id.qrcode -> replaceFragment(LoginFragment())
                R.id.wallet -> replaceFragment(LoginFragment())
            }
            true
        }

        val btnLogin = findViewById<ImageButton>(R.id.logo_for_person_without_logo)
        btnLogin.setOnClickListener {
            // Substitui o fragmento atual pelo fragmento de login
            setupInfoBinding()
        }
    }

    fun setupLoginBinding() {
        loginBinding = ActivityMainWithLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)
        replaceFragment(HomeLoginFragment())

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = ""
        setSupportActionBar(toolbar)

        loginBinding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> replaceFragment(HomeLoginFragment())
                R.id.ticket -> replaceFragment(TicketFragment())
                R.id.map -> replaceFragment(MapFragment())
                R.id.qrcode -> replaceFragment(QrcodeFragment())
                R.id.wallet -> replaceFragment(WalletFragment())
            }
            true
        }

        val btnLogout = findViewById<ImageButton>(R.id.logo_for_person_with_logo)
        btnLogout.setOnClickListener {
            // Substitui o fragmento atual pelo fragmento de login
            setupInfoBinding()
        }

    }

    fun setupShopBinding() {
        shopBinding = ActivityMainWithCartBinding.inflate(layoutInflater)
        setContentView(shopBinding.root)
        replaceFragment(BuyTicketFragment())

        toolbar = findViewById(R.id.toolbar)
        toolbar.title = ""
        setSupportActionBar(toolbar)

        shopBinding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> setupLoginBinding()
                R.id.ticket -> {
                    setupLoginBinding()
                    replaceFragment(TicketFragment(), R.id.ticket)
                }

                R.id.map -> {
                    setupLoginBinding()
                    replaceFragment(MapFragment(), R.id.map)
                }

                R.id.qrcode -> {
                    setupLoginBinding()
                    replaceFragment(QrcodeFragment(), R.id.qrcode)
                }

                R.id.wallet -> {
                    setupLoginBinding()
                    replaceFragment(WalletFragment(), R.id.wallet)
                }
            }
            true
        }

        val btnLogout = findViewById<ImageButton>(R.id.logo_for_person_with_logo)
        btnLogout.setOnClickListener {
            // Substitui o fragmento atual pelo fragmento de login
            setupInfoBinding()
        }
    }

    private fun setupInfoBinding() {
        infoBinding = ActivityMainInfoPageBinding.inflate(layoutInflater)
        setContentView(infoBinding.root)
        if (!isLogged) {
            replaceFragment(LoginFragment())

            toolbar = findViewById(R.id.toolbar)
            toolbar.title = ""
            setSupportActionBar(toolbar)

            val btnClose = findViewById<ImageButton>(R.id.close_icon)
            btnClose.setOnClickListener {
                setupNotLoginBinding()
            }
        } else {
            replaceFragment(AccountInfoFragment())

            toolbar = findViewById(R.id.toolbar)
            toolbar.title = ""
            setSupportActionBar(toolbar)

            val btnClose = findViewById<ImageButton>(R.id.close_icon)
            btnClose.setOnClickListener {
                setupLoginBinding()
            }

        }
    }

        fun replaceFragment(fragment: Fragment, menuItemId: Int? = null) {
            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout, fragment)
            fragmentTransaction.commit()

            // If a menu item ID is provided, set the selected item in the bottom navigation view
            if (!isLogged) {
                menuItemId?.let {
                    loginBinding.bottomNavigationView.selectedItemId = it
                }
            } else {
                menuItemId?.let {
                    loginBinding.bottomNavigationView.selectedItemId = it
                }
            }
        }

        fun exibirDatePicker(view: View) {
            val textbox = view as EditText
            val cal = Calendar.getInstance()
            val year = cal.get(Calendar.YEAR)
            val month = cal.get(Calendar.MONTH)
            val day = cal.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(
                textbox.context,
                { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDay: Int ->
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                    val currentDate = sdf.format(Date())
                    if (selectedDate >= currentDate &&
                        (textbox.id == R.id.returnBox || selectedDate >= (findViewById<EditText>(R.id.departureBox).text.toString()))
                    ) {
                        textbox.setText(selectedDate)
                    } else {
                        Toast.makeText(
                            textbox.context,
                            "Escolha uma data válida",
                            Toast.LENGTH_SHORT
                        )
                            .show()
                    }
                },
                year,
                month,
                day
            )

            datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
            if (textbox.id == R.id.returnBox) { // Se o EditText for ReturnBox
                val departureBox = findViewById<EditText>(R.id.departureBox)
                // Definir a data mínima como a data selecionada na DepartureBox
                val departureDate = departureBox.text.toString()
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val minDate = sdf.parse(departureDate).time
                datePickerDialog.datePicker.minDate = minDate
            }
            datePickerDialog.show()
        }

        //para a caixa de texto do Return
        fun onClickReturnBox(view: View) {
            val returnBox = findViewById<EditText>(R.id.returnBox)
            exibirDatePicker(returnBox)
        }

        //para a caixa de texto do Departure
        fun onClickDepartureBox(view: View) {
            val departureBox = findViewById<EditText>(R.id.departureBox)
            exibirDatePicker(departureBox)
        }

        fun onClickImageButtonCart(view: View) {
            val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
            drawerLayout.openDrawer(GravityCompat.START)
        }

        fun limparCaixasTexto(view: View) {
            val fromBox = findViewById<EditText>(R.id.fromBox)
            val toBox = findViewById<EditText>(R.id.toBox)
            val departureBox = findViewById<EditText>(R.id.departureBox)
            val returnBox = findViewById<EditText>(R.id.returnBox)

            // Limpar o texto em todas as caixas de texto
            fromBox.setText("")
            toBox.setText("")
            departureBox.setText("")
            returnBox.setText("")
        }

        fun incrementCartItemCount() {
            val cartItemCountTextView = findViewById<TextView>(R.id.cartItemCountTextView)
            val currentCount = cartItemCountTextView.text.toString().toInt()
            val newCount = currentCount + 1
            cartItemCountTextView.text = newCount.toString()
        }

        fun atualizarCarteira(view: View, moneyToAdd: EditText) {
            val walletBox = findViewById<TextView>(R.id.walletBox)
            val walletValue = walletBox.text.toString().replace("€", "").toDoubleOrNull()
            val strMoney = moneyToAdd.text.toString().toDoubleOrNull()

            if (walletValue != null && strMoney != null) {
                val newWalletValue = walletValue + strMoney
                val newWalletValueStr = String.format("%.2f€", newWalletValue)
                walletBox.setText(newWalletValueStr)
                moneyToAdd.setText("")

                // Save the new wallet value to shared preferences
                val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("walletValue", newWalletValueStr)
                editor.apply()
            }
        }

        fun adicionarDinheiroMBway(view: View) {
            val moneyToAdd = findViewById<EditText>(R.id.moneyInputBox)
            atualizarCarteira(view, moneyToAdd)
        }

        fun adicionarDinheiroMultibanco(view: View) {
            val moneyToAdd = findViewById<EditText>(R.id.moneyInputBox2)
            atualizarCarteira(view, moneyToAdd)
        }

}