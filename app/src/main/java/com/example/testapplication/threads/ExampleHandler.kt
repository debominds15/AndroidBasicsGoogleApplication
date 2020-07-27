package com.example.testapplication.threads

import android.os.Handler
import android.os.Message
import android.util.Log

const val TASK_A = 1
const val TASK_B = 2

class ExampleHandler : Handler(){
    val TAG: String? = ExampleHandler::class.simpleName
    override fun handleMessage(msg: Message) {
        when(msg.what){
            TASK_A -> {
                Log.d(TAG, "Task A executed...")
            }

            TASK_B -> {
                Log.d(TAG, "Task B executed...")
            }

            else -> {
                Log.d(TAG, "Else...")
            }
        }
    }
}