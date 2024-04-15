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
import android.app.DatePickerDialog
import android.widget.DatePicker
import android.view.View
import java.util.*
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat



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
                    (textbox.id == R.id.returnBox || selectedDate >= (findViewById<EditText>(R.id.departureBox).text.toString()))) {
                    textbox.setText(selectedDate)
                } else {
                    Toast.makeText(textbox.context, "Escolha uma data válida", Toast.LENGTH_SHORT).show()
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


}