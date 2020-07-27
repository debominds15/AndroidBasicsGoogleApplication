package com.example.testapplication.kotlinplayground

//Factory design pattern using companion object
class Bike{
    companion object{
        //Factory
        fun getInstance() = Bike()
    }

    fun ride(){
        println("Riding Bike...")
    }
}

fun main(args: Array<String>){
    Bike.getInstance().ride()
}