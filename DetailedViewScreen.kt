package com.example.practicumexam

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedViewScreen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val days = arrayOf(
            "Monday", "Tuesday", "Wednesday", "Thursday",
            "Friday", "Saturday", "Sunday"
        )
        val minimumTemperature = arrayOf(
            12, 15, 17, 16, 8, 11, 9
        )
        val maximumTemperature = arrayOf(
            25, 29, 30, 30, 27, 22, 22
        )
        val weatherCondition = arrayOf(
            "Sunny", "Sunny", "Sunny", "Sunny",
            "Windy", "Foggy", "Cloudy"
        )

        val txtDetails: TextView = findViewById(R.id.TxtDetails)
        val txtAverage: TextView = findViewById(R.id.TxtAverage)
        val btnBack: Button = findViewById(R.id.BtnBack)

        intent.getStringExtra("day")
        intent.getStringExtra("minimumTemperature")
        intent.getStringExtra("maximumTemperature")
        intent.getStringExtra("weatherCondition")

        var details = ""
        for (i in days.indices) {
            details += "Day: ${days[i]}\n"
            details += "MinimumTemperature: ${minimumTemperature[i]} minutes\n"
            details += "MaximumTemperature: ${maximumTemperature[i]} minutes\n"
            details += "WeatherConditions: ${weatherCondition.getOrNull(i) ?: "N/A"}\n\n"
        }
        txtDetails.text = details

        minimumTemperature.average()
        maximumTemperature.average()
        "Average Minimum temperature: ${
            "%.2f".format(minimumTemperature)
        } minutes\n" +
                "Average maximum temperature: ${"%.2f".format(maximumTemperature)} minutes"

        btnBack.setOnClickListener {
            finish()

        }.also { txtAverage.text = it.toString() }
    }
}

