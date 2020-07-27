package com.example.testapplication.threads

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.os.SystemClock
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.R

class ThreadActivityNew : AppCompatActivity() {

    val TAG: String? = ThreadActivityNew::class.simpleName
    val exampleLooperThread =  ExampleLooperThread()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_thread)

    }

    fun startThread(v: View){
        exampleLooperThread.start()
    }

    fun stopThread(v: View){
        exampleLooperThread.looper.quit()
    }

    fun taskA(v: View){
        var message = Message.obtain()
        message.what = TASK_A
        exampleLooperThread.handler.sendMessage(message)


        //var handler = Handler(exampleLooperThread.looper)


       //exampleLooperThread.handler.post {
      /* handler.post { // this runnable object has implicit reference of parent activity and can lead to memory leaks. for e.g, on rotating screen
           for (i in 1..5){
               Log.d(TAG, "run: $i")
               SystemClock.sleep(1000)
           }
       }*/
    }

    fun taskB(v: View){
        var message = Message.obtain()
        message.what = TASK_B
        exampleLooperThread.handler.sendMessage(message)
    }
}