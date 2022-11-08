package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //private fields of the class
    private lateinit var _button_explicit: Button
    private lateinit var _button_explicit_result: Button
    private lateinit var _textview: TextView
    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _textview = findViewById<TextView>(R.id.textview)
        _button_explicit = findViewById<Button>(R.id.button_explicit_intent)
        _button_explicit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                startWritingJournal()
            }
        })
        _button_explicit_result = findViewById<Button>(R.id.button_explicit_intent_result)
        _button_explicit_result.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                startReadingJournal()
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode==16 && resultCode == RESULT_OK){
            _textview.setText(data?.getStringExtra("entered"))
            }
    }

    private fun startWritingJournal(){
        var intent:Intent = Intent(this, WriteJournal::class.java)
        intent.putExtra("count", count)
        startActivity(intent)
        count++
    }

    private fun startReadingJournal(){
        var intent:Intent= Intent(this, ReadJournal::class.java)
        startActivityForResult(intent,16)
    }
}