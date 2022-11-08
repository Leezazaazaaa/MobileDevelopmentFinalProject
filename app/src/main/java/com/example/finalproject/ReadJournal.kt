package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ReadJournal: AppCompatActivity() {
    private lateinit var _button: Button
    private lateinit var _edittext: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read)

        _edittext = findViewById<EditText>(R.id.edittext)
        _button = findViewById<Button>(R.id.button)
        _button.setOnClickListener(object :View.OnClickListener{
            override fun onClick(p0: View?) {
                var result:Intent = Intent(Intent.ACTION_VIEW)
                result.putExtra("entered", _edittext.text.toString())
                setResult(RESULT_OK, result)
                finish()
            }

        })

    }
}