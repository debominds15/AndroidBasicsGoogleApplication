package com.example.testapplication.kotlinplayground

interface People{
    fun think()
}

fun main(args: Array<String>){
    var debo : People = object : People{
        override fun think() {
            println("Anonymous class implemented...")
        }
    }

    debo.think()
}