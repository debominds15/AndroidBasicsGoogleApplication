package com.example.testapplication.service

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.R
import kotlinx.android.synthetic.main.activity_service.*

class ServiceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_service)
        buttonStart.setOnClickListener(View.OnClickListener {
            ForegroundService.startService(this, "Foreground Service is running...")
        })
        buttonStop.setOnClickListener(View.OnClickListener {
            ForegroundService.stopService(this)
        })
    }
}