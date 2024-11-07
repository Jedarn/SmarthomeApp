package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var temperatureValue: TextView
    private lateinit var humidityValue: TextView
    private lateinit var pressureValue: TextView
    private lateinit var uvValue: TextView
    private lateinit var lightValue: TextView
    private lateinit var motionValue: TextView
    private lateinit var vibrationValue: TextView
    private lateinit var selectedTemperature: TextView
    private lateinit var temperatureSeekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val switch1 = findViewById<Switch>(R.id.switch1)
        val switch2 = findViewById<Switch>(R.id.switch2)
        val buttonOpenDoor = findViewById<Button>(R.id.buttonOpenDoor)
        val buttonLockDoor = findViewById<Button>(R.id.buttonLockDoor)
        val buttonSetTemperature = findViewById<Button>(R.id.buttonSetTemperature)

        temperatureValue = findViewById(R.id.temperatureValue)
        humidityValue = findViewById(R.id.humidityValue)
        pressureValue = findViewById(R.id.pressureValue)
        uvValue = findViewById(R.id.uvValue)
        lightValue = findViewById(R.id.lightValue)
        motionValue = findViewById(R.id.motionValue)
        vibrationValue = findViewById(R.id.vibrationValue)
        selectedTemperature = findViewById(R.id.selectedTemperature)
        temperatureSeekBar = findViewById(R.id.temperatureSeekBar)

        switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Light 1 On", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Light 1 Off", Toast.LENGTH_SHORT).show()

            }
        }

        switch2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Light 2 On", Toast.LENGTH_SHORT).show()

            } else {
                Toast.makeText(this, "Light 2 Off", Toast.LENGTH_SHORT).show()

            }
        }

        buttonOpenDoor.setOnClickListener {
            Toast.makeText(this, "Opening Door", Toast.LENGTH_SHORT).show()

        }

        buttonLockDoor.setOnClickListener {
            Toast.makeText(this, "Locking Door", Toast.LENGTH_SHORT).show()

        }

        temperatureSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                selectedTemperature.text = "$progress°C"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        buttonSetTemperature.setOnClickListener {
            val temperature = temperatureSeekBar.progress
            Toast.makeText(this, "Setting temperature to $temperature°C", Toast.LENGTH_SHORT).show()

        }

        // Example sensor data
        updateSensorData(25.0, 60.0, 1013.0, 5.0, 300.0, "Detected", "Low")
    }

    private fun updateSensorData(
        temperature: Double,
        humidity: Double,
        pressure: Double,
        uvIndex: Double,
        light: Double,
        motion: String,
        vibration: String
    ) {
        temperatureValue.text = String.format(Locale.getDefault(), "%.1f °C", temperature)
        humidityValue.text = String.format(Locale.getDefault(), "%.1f %%", humidity)
        pressureValue.text = String.format(Locale.getDefault(), "%.1f hPa", pressure)
        uvValue.text = String.format(Locale.getDefault(), "%.1f", uvIndex)
        lightValue.text = String.format(Locale.getDefault(), "%.1f lx", light)
        motionValue.text = motion
        vibrationValue.text = vibration
    }
}

