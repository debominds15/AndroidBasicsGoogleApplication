package com.example.testapplication.threads

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.R
import kotlinx.android.synthetic.main.activity_thread.*


class ThreadActivity: AppCompatActivity(){

    val TAG: String? = ThreadActivity::class.simpleName
    var exampleThread = ExampleThread(10)
    var mainHandler = Handler()
    var btn_start : Button ? = null
    var stopThread = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        btn_start = findViewById(R.id.btn_start)
        btn_start?.setOnClickListener {
            startThread()
        }

        btn_stop.setOnClickListener {
            stopThread()
        }
    }

    private fun startThread() {
        stopThread = false
        var exampleRunnable = ExampleRunnable(10)
        Thread(exampleRunnable).start()
        //exampleThread.start()
    }

    private fun stopThread() {
        //exampleThread.stop()
        stopThread = true
    }

    inner class ExampleThread(seconds: Int) : Thread(){
        private var seconds: Int
        init {
            this.seconds = seconds
        }
        override fun run() {
            for(i in 1..seconds){
                Thread.sleep(1000)
                Log.d("ExampleThread", "startThread: $i")
            }
        }
    }

    inner class ExampleRunnable(seconds: Int) : Runnable{
        private var seconds: Int
        init {
            this.seconds = seconds
        }
        override fun run() {
            for(i in 0 until seconds){
                var localHandler = Handler(Looper.getMainLooper())

                if(stopThread){
                    return
                }

                if( i == 5){
                    /*localHandler.post(Runnable {
                        btn_start?.setText("50%")
                    })*/

                    /* btn_start?.post(Runnable {
                        btn_start?.setText("50%")
                    })*/

                    runOnUiThread {
                        btn_start?.setText("50%")
                    }
                }


                Thread.sleep(1000)
                Log.d("ExampleThread", "startThread: $i")
            }
        }

    }
}