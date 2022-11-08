package com.example.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var _latitude: TextView
    private lateinit var _longitude: TextView
    private lateinit var _button: Button
    private lateinit var _linear_layout: LinearLayout
    private lateinit var _lm: LocationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        _latitude = findViewById<TextView>(R.id.latitude)
        _longitude = findViewById<TextView>(R.id.longitude)
        _button = findViewById<Button>(R.id.button)
        _linear_layout = findViewById<LinearLayout>(R.id.linear_layout)

        _lm = getSystemService(LOCATION_SERVICE) as LocationManager
        _button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?){
                addLocationListener()
            }
        })
    }
    private fun addLocationListener(){
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
            requestPermissions(arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION), 1)
            return
        }
        _lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0f, object : LocationListener{
            override fun onLocationChanged(p0: Location) {
                _latitude.setText("Latitude:" + p0.latitude)
                _longitude.setText("Longitude:" + p0.longitude)
            }
        })
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(grantResults[0] == PackageManager.PERMISSION_DENIED || grantResults[1] == PackageManager.PERMISSION_DENIED){
            var snackbar: Snackbar = Snackbar.make(_linear_layout, "App will not work withoit location permission", Snackbar.LENGTH_LONG)
            snackbar.show()
            }
        else {
            var snackbar: Snackbar = Snackbar.make(_linear_layout, "location permission granted", Snackbar.LENGTH_LONG)
            snackbar.show()
        }
    }
}