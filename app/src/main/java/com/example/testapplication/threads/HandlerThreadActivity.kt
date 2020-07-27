package com.example.testapplication.threads

import android.os.*
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.R

class HandlerThreadActivity : AppCompatActivity(){

    var handlerThread = ExampleHandlerThread()
    var runnable1 = ExampleRunnable1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_handler)
        handlerThread.start()

    }

    fun doWork(view: View){

        //1st way of sending message to handler to execute messages
        var msg = Message.obtain()
        msg.what = 1
        msg.arg1 = 23
        msg.obj = "obj String"

        handlerThread.handler.sendMessage(msg)
        //handlerThread.handler.sendEmptyMessage(1)
        handlerThread.handler.post(BlaBal.ExampleRunnable2)
        handlerThread.handler.post(runnable1)

        //2nd way of sending message to handler to execute messages
      /*  var msg = Message.obtain(handlerThread.handler)
        msg.what = 1
        msg.arg1 = 23
        msg.obj = "obj String"
        msg.sendToTarget()*/

        //3rd way of sending message to handler to execute messages
    /*    var msg = Message.obtain()
        msg.what = 1
        msg.arg1 = 23
        msg.obj = "obj String"
        msg.target = handlerThread.handler*/

        //4th way of sending message to handler to execute messages
        //handlerThread.handler.obtainMessage(1, 23, 0, "obj String").sendToTarget()

        //Sending runnable instance directly to handler - No need to override handleMessage() in handler
        /*handlerThread.handler.postDelayed(ExampleRunnable1, 2000)
        handlerThread.handler.post(BlaBal.ExampleRunnable2)
        handlerThread.handler.postAtFrontOfQueue(BlaBal.ExampleRunnable2)*/
    }

    fun removeMessages(view: View){
        //handlerThread.handler.removeCallbacksAndMessages(null)
        handlerThread.handler.removeCallbacks(runnable1)
    }

    override fun onDestroy() {
        super.onDestroy()
        handlerThread.quit()
    }

    companion object ExampleRunnable1 : Runnable{
        val TAG : String? = HandlerThreadActivity::class.simpleName

        override fun run() {
            for (i in  0..4){
                Log.d(TAG, "Runnable1 : $i")
                SystemClock.sleep(1000)
            }
        }

    }

    class BlaBal{
        companion object ExampleRunnable2: Runnable{
            val TAG : String? = HandlerThreadActivity::class.simpleName

            override fun run() {
                for (i in  0..4){
                    Log.d(TAG, "Runnable2 : $i")
                    SystemClock.sleep(1000)
                }
            }

        }
    }
}


/*
class HandlerThreadActivity : AppCompatActivity(){

    var handlerThread = HandlerThread("MyHandlerThread")
    lateinit var handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread_handler)
        handlerThread.start()
        handler = Handler(handlerThread.looper)

    }

    fun doWork(view: View){
        handler.postDelayed(ExampleRunnable1, 2000)
        handler.post(BlaBal.ExampleRunnable2)
    }

    fun removeMessages(view: View){

    }

    override fun onDestroy() {
        super.onDestroy()
        handlerThread.quit()
    }

    companion object ExampleRunnable1 : Runnable{
        val TAG : String? = HandlerThreadActivity::class.simpleName

        override fun run() {
            for (i in  0..4){
                Log.d("", "Runnable1 : $i")
                SystemClock.sleep(1000)
            }
        }

    }

    class BlaBal{
        companion object ExampleRunnable2: Runnable{
            val TAG : String? = HandlerThreadActivity::class.simpleName

            override fun run() {
                for (i in  0..4){
                    Log.d("", "Runnable2 : $i")
                    SystemClock.sleep(1000)
                }
            }

        }
    }
}*/
