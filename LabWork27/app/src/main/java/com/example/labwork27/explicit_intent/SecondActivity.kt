package com.example.labwork27.explicit_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.labwork27.R

class SecondActivity : AppCompatActivity(){
    private lateinit var _button: Button
    private lateinit var _textview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        _textview = findViewById(R.id.textview)
        var count: Int = intent.getIntExtra("count", 0)
        _textview.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                finish()
            }
        })
    }

}



