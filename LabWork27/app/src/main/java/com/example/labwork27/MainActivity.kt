package com.example.labwork27

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var _button_explicit: Button
    private lateinit var _button_explicit_result: Button
    private lateinit var _textview: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _textview = findViewById<TextView>(R.id.textview)

        _button_explicit = findViewById(R.id.button_explicit_intent)
        _button_explicit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                startSecondActivy()
            }

        })

    }
}