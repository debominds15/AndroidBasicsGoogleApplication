package com.example.testapplication.threads

import android.os.*
import android.util.Log

const val EXAMPLE_TASK = 1

class ExampleHandlerThread :
    HandlerThread("ExampleHandlerThread", Process.THREAD_PRIORITY_BACKGROUND) {
    val TAG: String? = ExampleHandlerThread::class.simpleName
    lateinit var handler: Handler

    override fun onLooperPrepared() {
        handler = object : Handler() {
            override fun handleMessage(msg: Message) {
                when (msg.what) {
                    EXAMPLE_TASK -> {
                        Log.d(TAG, "Example Task, arg1: ${msg.arg1} , obj: ${msg.obj}")
                        for (i in 0..4) {
                            Log.d(TAG, "handleMessage: $i")
                            SystemClock.sleep(1000)
                        }
                    }
                }
            }
        }
    }
}