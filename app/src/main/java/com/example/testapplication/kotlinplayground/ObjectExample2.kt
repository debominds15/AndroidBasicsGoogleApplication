package com.example.testapplication.kotlinplayground

fun main(args: Array<String>){

    println(Laptop.count)
    println(Laptop.typeOfLaptops())
    Laptop.calculateSquare(5)
}

open class MySuperClass{

    open fun calculateSquare(a: Int) : Unit{
        println(a * a)
    }

}

object Laptop : MySuperClass(){

    var count: Int = 5                  // Behaves like STATIC variable

    init {
        println("Initializing Object class...")
    }

    fun typeOfLaptops(): String{        // Behaves like STATIC method
        return "High Configuration Laptop"
    }

    override fun calculateSquare(a: Int): Unit {    // Currently, Behaving like STATIC methos
        super.calculateSquare(a)
        println("calculateSquare called from Laptop .. $a")
    }
}