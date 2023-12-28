package com.santidevs.painter

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var drawPathView: DrawPath

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawPathView = findViewById(R.id.drawPathView)

        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener {
            drawPathView.clearCanvas()
        }
    }
}
