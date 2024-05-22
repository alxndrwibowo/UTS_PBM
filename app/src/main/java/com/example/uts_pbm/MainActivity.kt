package com.example.uts_pbm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var btnPost: Button

    lateinit var edTitle: EditText
    var title = ""
    lateinit var rbAdult: RadioButton
    lateinit var rbKids: RadioButton
    var rb = ""
    lateinit var cbThriller: CheckBox
    lateinit var cbHorror: CheckBox
    lateinit var cbAction: CheckBox
    lateinit var cbRomance: CheckBox
    lateinit var cbComedy: CheckBox
    lateinit var cbFantasy: CheckBox
    var cb = ""

    lateinit var sYear: Spinner
    var year = ""
    val pilihanYear = arrayOf("2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024")
    var posisiYear = 0

    lateinit var sHour: Spinner
    var hour = ""
    val pilihanHour = arrayOf("1", "2", "3", "4", "5")
    var posisiHour = 0

    lateinit var sMinutes: Spinner
    var minutes = ""
    val pilihanMinutes = arrayOf("10", "20", "30", "40", "50")
    var posisiMinutes = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnPost = findViewById(R.id.btnPost)
        edTitle = findViewById(R.id.edTitle)
        rbAdult = findViewById(R.id.rbAdult)
        rbKids = findViewById(R.id.rbKids)
        cbThriller = findViewById(R.id.cbThriller)
        cbHorror = findViewById(R.id.cbHorror)
        cbAction = findViewById(R.id.cbAction)
        cbRomance = findViewById(R.id.cbRomance)
        cbComedy = findViewById(R.id.cbComedy)
        cbFantasy = findViewById(R.id.cbFantasy)
        sYear = findViewById(R.id.sYear)
        sHour = findViewById(R.id.sHour)
        sMinutes = findViewById(R.id.sMinutes)

        btnPost.setOnClickListener(this)

        val arrayAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pilihanYear)
        sYear.adapter = arrayAdapter

        sYear.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                posisiYear = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val arrayAdapter2 =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pilihanHour)
        sHour.adapter = arrayAdapter2

        sHour.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                posisiHour = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val arrayAdapter3 =
            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, pilihanMinutes)
        sMinutes.adapter = arrayAdapter3

        sMinutes.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                posisiMinutes = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnPost -> {
                title = edTitle.text.toString()
                if (rbAdult.isChecked) {
                    rb = "Adult (17+)"
                } else {
                    val gender = "Perempuan"
                    rb = "Kids"
                }

                if (cbThriller.isChecked) {
                    cb = cb + "Thriller, "
                }
                if (cbHorror.isChecked) {
                    cb = cb + "Horror, "
                }
                if (cbAction.isChecked) {
                    cb = cb + "Action, "
                }
                if (cbRomance.isChecked) {
                    cb = cb + "Romance, "
                }
                if (cbComedy.isChecked) {
                    cb = cb + "Comedy, "
                }
                if (cbFantasy.isChecked) {
                    cb = cb + "Fantasy, "
                }
                cb = cb.substring(0, cb.length-2)

                year = pilihanYear[posisiYear]
                hour = pilihanHour[posisiHour]
                minutes = pilihanMinutes[posisiMinutes]

                val intentData = Intent(this@MainActivity, ActivityData::class.java)
                intentData.putExtra(ActivityData.extraTitle, title)
                intentData.putExtra(ActivityData.extraRb, rb)
                intentData.putExtra(ActivityData.extraCb, cb)
                intentData.putExtra(ActivityData.extraYear, year)
                intentData.putExtra(ActivityData.extraHour, hour)
                intentData.putExtra(ActivityData.extraMinutes, minutes)
                startActivity(intentData)
            }
        }
    }
}