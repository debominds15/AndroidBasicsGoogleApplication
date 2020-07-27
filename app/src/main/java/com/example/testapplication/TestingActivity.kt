package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_testing.*

class TestingActivity: AppCompatActivity() {
    val TAG = "TestingActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_testing)
        Log.d(TAG, "onCreate called!!")

        var message = edt_msg.text.toString()

        btn_share_data.setOnClickListener {

            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent, "Share to:"))
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart called!!")
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called!!")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called!!")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called!!")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called!!")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called!!")
    }
}