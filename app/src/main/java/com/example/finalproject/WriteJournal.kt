package com.example.finalproject

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//@Entity(tableName = "journal")
class WriteJournal: AppCompatActivity() {
//    @PrimaryKey(autoGenerate = true)
//    var  ID:Int = 0
//    @ColumnInfo(name = "title")
//    val title:String = ""
//    @ColumnInfo(name = "journal")
//    val journal:String = ""
//    @ColumnInfo(name = "date")
//    val date:String = ""
//
//    get() = field
    private lateinit var _button: Button
    private lateinit var _textview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write)

        _textview = findViewById<TextView>(R.id.textview)
        var count: Int = intent.getIntExtra("count", 0)
        _textview.setText("The value of count passed by MainActivity is: " + count.toString())

        //pull the button from the layout and then set a listener that will close this activity
        _button = findViewById<Button>(R.id.button)
        _button.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View){
                finish()
            }
        })
    }
}