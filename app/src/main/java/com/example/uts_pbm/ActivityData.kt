package com.example.uts_pbm

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ActivityData : AppCompatActivity() {

    companion object {
        const val extraTitle = "extra_title"
        const val extraRb = "extra_rb"
        const val extraCb = "extra_cb"
        const val extraYear = "extra_year"
        const val extraHour = "extra_hour"
        const val extraMinutes = "extra_minutes"
    }

    lateinit var tvData: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_data)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvData = findViewById(R.id.tvData)

        val title = intent.getStringExtra(extraTitle)
        val rb = intent.getStringExtra(extraRb)
        val cb = intent.getStringExtra(extraCb)
        val year = intent.getStringExtra(extraYear)
        val hour = intent.getStringExtra(extraHour)
        val minutes = intent.getStringExtra(extraMinutes)

        val text = """
        |Title: $title
        |Watch for: $rb
        |Genre: $cb
        |Year: $year
        |Duration: ${hour}h, ${minutes}m
        """.trimMargin()

        tvData.text = text
    }
}