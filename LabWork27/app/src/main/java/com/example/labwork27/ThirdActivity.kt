package com.example.labwork27

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ThirdActivity : AppCompatActivity(){
    private lateinit var _button: Button
    private lateinit var _editText: EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        _editText = findViewById<EditText>(R.id.edittext)

    }

}