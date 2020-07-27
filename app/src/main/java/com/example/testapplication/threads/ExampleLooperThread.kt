package com.example.testapplication.threads

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.util.Log

class ExampleLooperThread : Thread() {
    val TAG: String? = ExampleLooperThread::class.simpleName
    lateinit var handler: Handler
    lateinit var looper: Looper


    override fun run() {
        //1st Step: Until this statement, handler cannot be initialized
        Looper.prepare()

        looper = Looper.myLooper()!!

        //2nd Step: Initialize Handler object
        //handler = Handler()

        handler = ExampleHandler()

        //3rd step: Loop through the messageQueue and it will keep the thread Alive now
        Looper.loop()

        Log.d(TAG, "End of run()..")

    }
}