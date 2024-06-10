package com.example.practicumexam

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val txtDay: EditText = findViewById(R.id.TxtDay)
        val txtMinimum: EditText = findViewById(R.id.TxtMinimum)
        val txtMaximum: EditText = findViewById(R.id.TxtMaximum)

        val btnNext: Button = findViewById(R.id.BtnNext)
        val btnClear: Button = findViewById(R.id.BtnClear)
        val btnPrevious: Button = findViewById(R.id.BtnPrevious)

        val validDays = arrayOf(
            "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday"
        )
        val validMinimum = arrayOf(
            "12", "15", "17", "16",
            "8", "11", "9"
        )
        val validMaximum = arrayOf(
            "25", "29", "30", "30",
            "27", "22", "22"
        )
        arrayOf(
            "Sunny", "Sunny", "Sunny", "Sunny",
            "Windy", "Foggy", "Cloudy"
        )

        btnNext.setOnClickListener {
            val day = txtDay.text.toString()
            val minimumTemperature = txtMinimum.text.toString()
            val maximumTemperature = txtMaximum.text.toString()

            if (validDays.contains(day) && validMinimum.contains(minimumTemperature) &&
                validMaximum.contains(maximumTemperature)
            ) {
                val intent = Intent(this, DetailedViewScreen::class.java).apply {
                    putExtra("day", day)
                    putExtra("minimum", minimumTemperature)
                    putExtra("maximum", maximumTemperature)
                }
                startActivity(intent)
            }
        }

        btnClear.setOnClickListener {
            txtDay.text.clear()
            txtMinimum.text.clear()
            txtMaximum.text.clear()
        }

        btnPrevious.setOnClickListener {
            finish()
        }
    }
}
