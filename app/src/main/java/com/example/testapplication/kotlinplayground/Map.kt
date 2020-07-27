package com.example.testapplication.kotlinplayground

import android.annotation.SuppressLint

@SuppressLint("NewApi")
fun main(args: Array<String>){
    //Map  : Kay-Value Pair
    //var immutableMap = mapOf<Int, String>(1 to "Modi", 2 to "Yogi", 3 to "Debo")   //Immutable, Fixed Size, READ ONLY

    var mutableMap = HashMap<Int, String>()                                        //Mutable, No Fixed Size, READ and WRITE both

    mutableMap.apply {
        this.put(1, "Debo")
        this[9] = "Abhay"
        this[4] = "Rishi"

        this.replace(4, "Dude")
    }

    for (key in mutableMap.keys){
        println(" $key : ${mutableMap.get(key)}")
    }
}